package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
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

    @GetMapping("/Comment/Info")
    public List<Comment> list()
    {
        return service.list();
    }

    @GetMapping("/Comment/Info/{id}")
    public Optional<Comment> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @PostMapping("/Comment")
    public  void Add(@RequestBody ItemTextRequest request){
        Comment ent=new Comment();
        //question.setId(request.getId());
        ent.setText(request.getText());
        ent.setCreationDate(dbUtility.Now());
        ent.setTextStatus(dbUtility.quickTextStatus(1));
        ent.setUser(dbUtility.quickUser(request.getUserId()));
        ent.setAnswers(dbUtility.quickAnswer(request.getParentId()));
        service.Add(ent);;
    }

    @PutMapping ("/Comment")
    public void Update(@RequestBody ItemTextRequest  request)
    {
        service.Update(request.getId(),request.getText());
    }

    @DeleteMapping("/Comment/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

    @GetMapping("/Comment/search/{pattern}")
    public List<ItemTextInfo> Search(@PathVariable("pattern")  String pattern)
    {
        return service.Search(pattern);
    }

    @GetMapping("/Comment/{id}")
    public ItemTextInfo SelectOneInfo(@PathVariable("id") int id)
    {
        return service.SelectOneInfo(id);
    }

    @GetMapping("/Comment")
    public List<ItemTextInfo> listInfo()
    {
        return service.ListInfo();
    }
}
