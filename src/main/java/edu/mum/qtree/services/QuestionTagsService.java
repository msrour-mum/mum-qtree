package edu.mum.qtree.services;

import edu.mum.qtree.dao.QuestionTagsRepository;
import edu.mum.qtree.models.entities.QuestionTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTagsService {

    @Autowired
    private QuestionTagsRepository rep ;

    public void Add(QuestionTags questionTags)
    {
        rep.save(questionTags);
    }

    public void Delete(int id)
    {
        rep.deleteById(id);
    }

    public Optional<QuestionTags> SelectOne(int id)
    {
        return rep.findById(id);
    }

    public List<QuestionTags> list() { return (List<QuestionTags>) rep.findAll(); }
}
