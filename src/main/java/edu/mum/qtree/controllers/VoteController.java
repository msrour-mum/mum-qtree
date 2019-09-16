package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.custom.VoteRequest;
import edu.mum.qtree.models.entities.Vote;
import edu.mum.qtree.services.AnswerService;
import edu.mum.qtree.services.VoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Vote Resourse",description = "Vote Resourse")
public class VoteController {
    @Autowired
    private VoteService service;
    //APIs

    @ApiOperation(value = "Return List of Votes")
    @GetMapping("/Vote")
    public List<Vote> list()
    {
        return service.list();
    }

    @ApiOperation(value = "Return specific Vote by ID")
    @GetMapping("/Vote/{id}")
    public Optional<Vote> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @ApiOperation(value = "Adding new Vote")
    @PostMapping("/Vote")
    public  void Add(@RequestBody VoteRequest request)
    {
        Vote ent=new Vote();
        //question.setId(request.getId());
        ent.setLike(request.isLike());
        ent.setAnswer(dbUtility.quickAnswer(request.getAnswerId()));
        ent.setUser(dbUtility.quickUser(request.getUserId()));
        service.Add(ent);
    }

    @PostMapping("/Vote")
    public  void Add(@RequestBody Vote ent)
    {

        service.Add(ent);
    }

    @ApiOperation(value = " Update specific Vote")
    @PutMapping("/Vote")
    public void Update(@RequestBody Vote ent)
    {
        service.Update(ent);;
    }

    @ApiOperation(value = " Remove specific Vote by ID")
    @DeleteMapping("/Vote/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

}


