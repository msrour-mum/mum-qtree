package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.custom.VoteRequest;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.services.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@Api(value = "Answer Resourse",description = "Answer Resourse")
@RestController
public class AnswerController
{
    @Autowired
    private AnswerService service;
    //APIs
    @PermitAll
    @ApiOperation(value = "Adding new Answer")
    @PostMapping("/Answer")
    @CrossOrigin(origins = "http://localhost:63342")
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

    @ApiOperation(value = " Update specific Answer")
    @PutMapping ("/Answer")
    public void Update(@RequestBody ItemTextRequest  request)
    {
        service.Update(request.getId(),request.getText());
    }

    @ApiOperation(value = " Remove specific Answer by ID")
    @DeleteMapping("/Answer/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        service.Delete(id);
    }

    @ApiOperation(value = "Return specific list of Answers by Search ")
    @GetMapping("/Answer/search/{pattern}")
    public List<ItemTextInfo> Search(@PathVariable("pattern")  String pattern)
    {
        return service.Search(pattern);
    }

    @ApiOperation(value = "Return specific Answer by ID")
    @GetMapping("/Answer/{id}")
    public ItemTextInfo SelectOneInfo(@PathVariable("id") int id)
    {
        return service.SelectOneInfo(id);
    }

    @ApiOperation(value = "Return List of all  Answers")
    @GetMapping("/Answer")
    public List<ItemTextInfo> listInfo()
    {
        return service.ListInfo();
    }

    @ApiOperation(value = "Make Vote on specific Answers")
    @PostMapping("/Answer/Vote")
    public void Vote(@RequestBody VoteRequest request)
    {
        service.Vote(request.getUserId(),request.getAnswerId(),request.isLike());
    }

    @GetMapping("/Answer/Question/{questionId}")
    public List<ItemTextInfo> ListAnswer(@PathVariable("questionId") long questionId)
    {
        return service.ListAnswer(questionId);
    }

}
