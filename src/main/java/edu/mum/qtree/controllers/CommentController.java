package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.services.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Comment Resourse",description = "Comment Resourse")
@RestController
public class CommentController
{
    @Autowired
    private CommentService service;
    //APIs
    @ApiOperation(value = "Return List of Comments")
    @GetMapping("/Comment/Info")
    public List<Comment> list()
    {
        return service.list();
    }

    @ApiOperation(value = "Return List of specific Comments by ID")
    @GetMapping("/Comment/Info/{id}")
    public Optional<Comment> SelectOne(@PathVariable("id") int id)
    {
        return service.SelectOne(id);
    }

    @ApiOperation(value = "Adding new Comment")
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

    @ApiOperation(value = "Update specific Comment")
    @PutMapping ("/Comment")
    public void Update(@RequestBody ItemTextRequest  request)
    {
        service.Update(request.getId(),request.getText());
    }

    @ApiOperation(value = "Delete new Comment by ID")
    @DeleteMapping("/Comment/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

    @ApiOperation(value = "Return specific list of Comments by Search ")
    @GetMapping("/Comment/search/{pattern}")
    public List<ItemTextInfo> Search(@PathVariable("pattern")  String pattern)
    {
        return service.Search(pattern);
    }

    @ApiOperation(value = "Return specific Comment by ID")
    @GetMapping("/Comment/{id}")
    public ItemTextInfo SelectOneInfo(@PathVariable("id") int id)
    {
        return service.SelectOneInfo(id);
    }

    @ApiOperation(value = "Return List of specific Comment by ID")
    @GetMapping("/Comment")
    public List<ItemTextInfo> listInfo()
    {
        return service.ListInfo();
    }


    @GetMapping("/Comment/Answer/{answerId}")
    public List<ItemTextInfo> ListAnswer(@PathVariable("answerId") long questionId)
    {
        return service.ListComment(questionId);
    }
}
