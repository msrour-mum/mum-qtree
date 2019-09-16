package edu.mum.qtree.services;

import edu.mum.qtree.dao.CommentRepository;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository rep;

    public void Add(Comment item)
    {
        rep.save(item);
    }
    public void Update(long id, String txt) {
        rep.UpdateData(id, txt);
    }
    public void Delete(long id)
    {
        rep.deleteById(id);
    }
    public Optional<Comment> SelectOne(long id)
    {
        return rep.findById(id);
    }
    public List<Comment> list()
    {
        return (List<Comment>) rep.findAll();
    }

    public List<ItemTextInfo> Search(String pattern) {

        List<Comment> lst = (List<Comment>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();
        for (int i = 0; i < lst.size(); i++) {
            Comment item = lst.get(i);
            if (item.getText().contains(pattern)) {
                ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getAnswers().getId());
                lstResult.add(txt);
            }
        }
        return lstResult;
    }

    public ItemTextInfo SelectOneInfo(long id) {
        Comment item = rep.findById(id).get();
        if (item == null)
            return null;
        ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getAnswers().getId());
        return txt;
    }

    public List<ItemTextInfo> ListInfo() {
        List<Comment> lst = (List<Comment>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();


        for (int i = 0; i < lst.size(); i++) {
            Comment item = lst.get(i);
            ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), item.getAnswers().getId());
            lstResult.add(txt);
        }
        return lstResult;
    }


    public List<ItemTextInfo> ListComment(long questionId) {
        List<Comment> lst = (List<Comment>) rep.findAll();
        ArrayList<ItemTextInfo> lstResult = new ArrayList<ItemTextInfo>();
        for (int i = 0; i < lst.size(); i++) {
            Comment item = lst.get(i);
            if (item.getAnswers().getId()== questionId) {
                ItemTextInfo txt = new ItemTextInfo(item.getId(), item.getText(), item.getUser().getId(), item.getTextStatus().getId(), item.getUser().getName(), item.getTextStatus().getName(), item.getCreationDate(), questionId);
                lstResult.add(txt);
            }
        }
        return lstResult;
    }
}
