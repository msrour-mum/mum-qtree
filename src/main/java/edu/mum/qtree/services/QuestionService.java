package edu.mum.qtree.services;

import edu.mum.qtree.dao.QuestionRepository;

import edu.mum.qtree.dao.QuestionTagsRepository;
import edu.mum.qtree.dao.TagRepository;
import edu.mum.qtree.dao.VoteRepository;
import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.QuestionTags;
import edu.mum.qtree.models.entities.Tag;
import edu.mum.qtree.models.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository rep;

    @Autowired
    @Qualifier("TagRepository")
    private TagRepository repTag;

    @Autowired
    @Qualifier("QuestionTagsRepository")
    private QuestionTagsRepository repQuestionTag;

    public QuestionRepository getRep() {
        return rep;
    }

    public void setRep(QuestionRepository rep) {
        this.rep = rep;
    }

    @Transactional
    public void Add(Question question) {
        Question q = rep.save(question);

        List<String> tags = dbUtility.getHashtag(q.getText());
        for (String t : tags) {
            Tag tag = null;
            if (repTag.findByName(t).isPresent())
                tag = repTag.findByName(t).get();
            if (tag == null)
                tag = repTag.save(new Tag(t));

            QuestionTags link = new QuestionTags();
            link.setQuestionId(q.getId());
            link.setTagId(tag.getId());
            repQuestionTag.save(link);
        }
    }

    public void Update(long id, String txt) {rep.UpdateData(id, txt);}

    public void Delete(long id) {
        rep.deleteById(id);
    }

    public Optional<Question> SelectOne(long id) {
        return rep.findById(id);
    }

    public List<Question> list() {
        return (List<Question>) rep.findAll();
    }

    public List<ItemTextInfo> Search(String pattern) {

        List<Question> lst = (List<Question>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();
        for (int i = 0; i < lst.size(); i++) {
            Question item = lst.get(i);
            if (item.getText().contains(pattern)) {
                ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), 0);
                lstResult.add(txt);
            }
        }
        return lstResult;
    }

    public ItemTextInfo SelectOneInfo(long id) {
        Question item = rep.findById(id).get();
        if (item == null)
            return null;
        ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), 0);
        return txt;
    }

    public List<ItemTextInfo> ListInfo() {
        List<Question> lst = (List<Question>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();


        for (int i = 0; i < lst.size(); i++) {
            Question item = lst.get(i);
            ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(),
                    item.getUser().getId(), item.getTextStatus().getId(),
                    item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), 0);
            lstResult.add(txt);
        }
        return lstResult;
    }



}
