package edu.mum.qtree.services;

import edu.mum.qtree.dao.VoteRepository;
import edu.mum.qtree.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository rep;

    public void Add(Vote item)
    {
        rep.save(item);
    }
    public void Update(Vote item)
    {
        rep.save(item);
    }
    public void Delete(int id)
    {
        rep.deleteById(id);
    }
    public Optional<Vote> SelectOne(int id)
    {
        return rep.findById(id);
    }
    public List<Vote> list()
    {
        return (List<Vote>) rep.findAll();
    }
}
