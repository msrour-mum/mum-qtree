package edu.mum.qtree.services;

import edu.mum.qtree.dao.TagRepository;
import edu.mum.qtree.models.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository rep;

    public void Add(Tag item)
    {
        rep.save(item);
    }
    public void Update(Tag item)
    {
        rep.save(item);
    }
    public void Delete(int id)
    {
        rep.deleteById(id);
    }
    public Optional<Tag> SelectOne(int id)
    {
        return rep.findById(id);
    }
    public List<Tag> list()
    {
        return (List<Tag>) rep.findAll();
    }
}
