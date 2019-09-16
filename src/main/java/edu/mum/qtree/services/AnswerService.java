package edu.mum.qtree.services;

import edu.mum.qtree.dao.AnswerRepository;
import edu.mum.qtree.dao.VoteRepository;
import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository rep;

    @Autowired
    @Qualifier("VoteRepository")
    private VoteRepository repVote;

    public void Add(Answer question)
    {
        rep.save(question);
    }
    public void Update(long id, String txt) {
        rep.UpdateData(id, txt);
    }
    public void Delete(long id)
    {
        rep.deleteById(id);
    }
    public Optional<Answer> SelectOne(long id)
    {
        return rep.findById(id);
    }
    public List<Answer> list()
    {
        return (List<Answer>) rep.findAll();
    }


    public List<ItemTextInfo> Search(String pattern) {

        List<Answer> lst = (List<Answer>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();
        for (int i = 0; i < lst.size(); i++) {
            Answer item = lst.get(i);
            if (item.getText().contains(pattern)) {
                ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getQuestion().getId());
                lstResult.add(txt);
            }
        }
        return lstResult;
    }

    public ItemTextInfo SelectOneInfo(long id) {
        Answer item = rep.findById(id).get();
        if (item == null)
            return null;
        ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getQuestion().getId());
        return txt;
    }

    public List<ItemTextInfo> ListInfo() {
        List<Answer> lst = (List<Answer>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();


        for (int i = 0; i < lst.size(); i++) {
            Answer item = lst.get(i);
            ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getQuestion().getId());
            lstResult.add(txt);
        }
        return lstResult;
    }

    public List<ItemTextInfo> ListAnswer(long questionId) {
        List<Answer> lst = (List<Answer>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();
        for (int i = 0; i < lst.size(); i++) {
            Answer item = lst.get(i);
            if (item.getQuestion().getId()== questionId) {
                ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), questionId);
                lstResult.add(txt);
            }
        }
        return lstResult;
    }

    public void Vote(int userId, long answerId, int like ) {

        //Optional<Vote> find =repVote.findByData(userId,answerId);
        Optional<Vote> find =repVote.findByData(dbUtility.quickUser( userId),dbUtility.quickAnswer(answerId));
        Vote vote=null;
        if(find.isPresent())
        {
            /*vote=find.get();
            vote.setLike(like);
            repVote.UpdateData(vote.getId(),like);*/

            vote =new Vote();
            vote.setAnswer(dbUtility.quickAnswer(answerId));
            vote.setUser(dbUtility.quickUser(userId));

            //vote.setId(userId);
            vote.setLike(like);
            repVote.save(vote);
        }
        else
        {
            vote =new Vote();
            vote.setAnswer(dbUtility.quickAnswer(answerId));
            vote.setUser(dbUtility.quickUser(userId));

            vote.setLike(like);
            repVote.save(vote);
        }
    }
}
