package edu.mum.qtree.controllers;

import edu.mum.qtree.models.Question;
import edu.mum.qtree.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController
{
    @Autowired
    private QuestionService questionService;
    //APIs

    @GetMapping("/Questions")
    public List<Question> list()
    {
        return questionService.list();
    }

    @GetMapping("/Questions/{id}")
    public Optional<Question> SelectOne(@PathVariable("id") int id)
    {
        return questionService.SelectOne(id);
    }

    @PostMapping("/Questions")
    public  void Add(@RequestBody Question question)
    {
         questionService.Add(question);;
    }

    @PutMapping ("/Questions")
    public void Update(@RequestBody Question question)
    {
        questionService.Update(question);;
    }

    @DeleteMapping("/Questions/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        questionService.Delete(id);
    }

}
