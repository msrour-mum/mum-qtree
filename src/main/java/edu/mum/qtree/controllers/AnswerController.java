package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.custom.VoteRequest;
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

    @GetMapping("/Answer/Info")
    public List<Answer> list()
    {
        return service.list();
    }

    @GetMapping("/Answer/Info/{id}")
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
    public void Update(@RequestBody ItemTextRequest  request)
    {
        service.Update(request.getId(),request.getText());
    }


    @DeleteMapping("/Answer/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }


    @GetMapping("/Answer/search/{pattern}")
    public List<ItemTextInfo> Search(@PathVariable("pattern")  String pattern)
    {
        return service.Search(pattern);
    }
    @GetMapping("/Answer/{id}")
    public ItemTextInfo SelectOneInfo(@PathVariable("id") int id)
    {
        return service.SelectOneInfo(id);
    }


    @GetMapping("/Answer")
    public List<ItemTextInfo> listInfo()
    {
        return service.ListInfo();
    }


    @PostMapping("/Answer/Vote")
    public void Vote(@RequestBody VoteRequest request)
    {
        service.Vote(request.getUserId(),request.getAnswerId(),request.getLike());
    }

}
