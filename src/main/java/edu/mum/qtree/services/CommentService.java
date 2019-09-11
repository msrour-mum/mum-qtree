package edu.mum.qtree.services;

import edu.mum.qtree.dao.CommentRepository;
import edu.mum.qtree.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void Update(Comment item)
    {
        rep.save(item);
    }
    public void Delete(int id)
    {
        rep.deleteById(id);
    }
    public Optional<Comment> SelectOne(int id)
    {
        return rep.findById(id);
    }
    public List<Comment> list()
    {
        return (List<Comment>) rep.findAll();
    }
}
