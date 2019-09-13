package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
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
    public  void Add(@RequestBody ItemTextRequest request)
    {
        Answer ent=new Answer();
        //question.setId(request.getId());
        ent.setText(request.getText());
        ent.setCreationDate(dbUtility.Now());
        ent.setTextStatus(dbUtility.quickTextStatus(1));
        ent.setUser(dbUtility.quickUser(request.getUserId()));
        ent.setQuestion(dbUtility.quickQuestion(request.getParentId()));
        service.Add(ent);;
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
