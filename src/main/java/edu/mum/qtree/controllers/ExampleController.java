package edu.mum.qtree.controllers;

import edu.mum.qtree.models.Question;
import edu.mum.qtree.services.ExampleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExampleController {



    @RequestMapping("/questions")
    public List<Question> questions()
    {
        ExampleService questionSrv = new ExampleService();

       // return questionSrv.getQuestions();

        return null;


    }

    @RequestMapping("/questions/{id}")
    public Question questions(@PathVariable("id") int id)
    {
        ExampleService questionSrv = new ExampleService();

        //return new Question(6, "q6");

        return null;


    }

    @PostMapping("/questions/add")
    public Question add(@RequestBody Question question)
    {
        ExampleService questionSrv = new ExampleService();

        return  question;


    }
}
