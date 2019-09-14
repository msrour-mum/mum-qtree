package edu.mum.qtree.services;

import edu.mum.qtree.dao.QuestionRepository;

import edu.mum.qtree.models.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository rep;

    public void Add(Question question)
    {
        rep.save(question);
    }

    public void Update(long id, String txt)
    {
        //rep.save(question);
        rep.UpdateData(id,txt);
    }

    public void Delete(long id)
    {
        rep.deleteById(id);
    }

    public Optional<Question> SelectOne(long id)
    {
        return rep.findById(id);
    }
    public List<Question> list()
    {
        return (List<Question>) rep.findAll();
    }


    /*public List<Question> Search(String txt)
    {
        return (List<Question>) rep.serachQuestion(txt);
    }*/
}
