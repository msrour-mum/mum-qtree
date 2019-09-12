package edu.mum.qtree.controllers;

import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController
{
    @Autowired
    private AnswerService service;
    //APIs

    @GetMapping("/Answer")
    public List<Answer> list()
    {
        return service.list();
    }

    @GetMapping("/Answer/{id}")
    public Optional<Answer> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @PostMapping("/Answer")
    public  void Add(@RequestBody Answer question)
    {
         service.Add(question);;
    }

    @PutMapping ("/Answer")
    public void Update(@RequestBody Answer question)
    {
        service.Update(question);;
    }

    @DeleteMapping("/Answer/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

}
