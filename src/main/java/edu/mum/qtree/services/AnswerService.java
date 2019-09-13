package edu.mum.qtree.services;

import edu.mum.qtree.dao.AnswerRepository;
import edu.mum.qtree.models.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository rep;

    public void Add(Answer question)
    {
        rep.save(question);
    }
    public void Update(Answer question)
    {
        rep.save(question);
    }
    public void Delete(int id)
    {
        rep.deleteById(id);
    }
    public Optional<Answer> SelectOne(int id)
    {
        return rep.findById(id);
    }
    public List<Answer> list()
    {
        return (List<Answer>) rep.findAll();
    }
}
