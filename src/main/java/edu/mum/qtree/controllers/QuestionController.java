package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.dbUtility;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.TextStatus;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Api(value = "Question Resourse",description = "Question Resourse")
@RestController
public class QuestionController
{
    @Autowired
    private QuestionService questionService;
    @GetMapping("/Question/Info")
    public List<Question> list()
    {
        return questionService.list();
    }


    @ApiOperation(value = "Adding new Question")
    @GetMapping("/Question/Info/{id}")
    public Optional<Question> SelectOne(@PathVariable("id") int id)
    {
        return questionService.SelectOne(id);
    }

    @PermitAll
    @PostMapping ("/Question/Add")
    @CrossOrigin(origins = "http://localhost:63342")
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

    @ApiOperation(value = "Update specific Question")
    @PutMapping ("/Question")
    public void Update(@RequestBody ItemTextRequest  request)
    {
        questionService.Update(request.getId(),request.getText());
    }

    @ApiOperation(value = "Delete Question by ID")
    @DeleteMapping("/Question/{id}")
    public void Delete(@PathVariable("id") int id)
    {
        questionService.Delete(id);
    }

    @ApiOperation(value = "Return list of Questions by Search ")
    @PermitAll

    @GetMapping("/Question/search/{pattern}")
    @CrossOrigin(origins = "http://localhost:63342")
    public List<ItemTextInfo> Search(@PathVariable("pattern")  String pattern)
    {
        return questionService.Search(pattern);
    }

    @ApiOperation(value = "Return specific Question by ID")
    @GetMapping("/Question/{id}")
    public ItemTextInfo SelectOneInfo(@PathVariable("id") int id)
    {
        return questionService.SelectOneInfo(id);
    }

    @ApiOperation(value = "Return List of Questions")
    @GetMapping("/Question")
    public List<ItemTextInfo> listInfo()
    {
        return questionService.ListInfo();
    }

    @GetMapping("/Question/Tag/{id}")
    public List<String> ListTags(@PathVariable("id") int id)
    {
        return questionService.ListTags(id);
    }
}
