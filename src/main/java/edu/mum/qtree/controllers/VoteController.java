package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.custom.VoteRequest;
import edu.mum.qtree.models.entities.Vote;
import edu.mum.qtree.services.AnswerService;
import edu.mum.qtree.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class VoteController {
    @Autowired
    private VoteService service;
    //APIs

    @GetMapping("/Vote")
    public List<Vote> list()
    {
        return service.list();
    }

    @GetMapping("/Vote/{id}")
    public Optional<Vote> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @PostMapping("/Vote")
    public  void Add(@RequestBody VoteRequest request)
    {
        Vote ent=new Vote();
        //question.setId(request.getId());
        ent.setLike(request.getLike());
        ent.setAnswer(dbUtility.quickAnswer(request.getAnswerId()));
        service.Add(ent);
    }

    @PutMapping("/Vote")
    public void Update(@RequestBody Vote ent)
    {
        service.Update(ent);;
    }

    @DeleteMapping("/Vote/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

}


