package edu.mum.qtree.controllers;

import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController
{
    @Autowired
    private CommentService service;
    //APIs

    @GetMapping("/Comment")
    public List<Comment> list()
    {
        return service.list();
    }

    @GetMapping("/Comment/{id}")
    public Optional<Comment> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @PostMapping("/Comment")
    public  void Add(@RequestBody Comment question)
    {
         service.Add(question);;
    }

    @PutMapping ("/Comment")
    public void Update(@RequestBody Comment question)
    {
        service.Update(question);;
    }

    @DeleteMapping("/Comment/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

}
