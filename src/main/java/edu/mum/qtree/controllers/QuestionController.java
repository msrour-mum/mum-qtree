package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.TextStatus;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Date;
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


   /* @GetMapping("/SearchQuestions")
    public List<Question> list(@RequestParam("s") String txt)
    {

        return questionService.Search(txt);
    }
*/



    @PostMapping("/Questions")
    public  void Add(@RequestBody ItemTextRequest  request)
    {
        Question question=new Question();
        //question.setId(request.getId());
        question.setText(request.getText());
        question.setCreationDate(dbUtility.Now());
        question.setTextStatus(dbUtility.quickTextStatus(1));
        question.setUser(dbUtility.quickUser(request.getUserId()));
        questionService.Add(question);;
    }

    @PutMapping ("/Questions")
    public void Update(ItemTextRequest  request)
    {
       // questionService.Update(request.getId(),request.getText());

        Question question=new Question();
        question.setId(request.getId());
        question.setText(request.getText());
        question.setCreationDate(dbUtility.Now());
        question.setTextStatus(dbUtility.quickTextStatus(1));
        question.setUser(dbUtility.quickUser(request.getUserId()));
        questionService.Add(question);;
    }

    @DeleteMapping("/Questions/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        questionService.Delete(id);
    }

}
