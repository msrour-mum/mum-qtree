package edu.mum.qtree.controller;


import edu.mum.qtree.controllers.QuestionController;

import edu.mum.qtree.dto.dbUtility;

import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.TextStatus;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class QuestionControllerTest {

    @InjectMocks
    private QuestionController questionController ;

    private QuestionService questionService = mock(QuestionService.class);
    List<Question> questions ;
    Question q1,q2,q3,q4,q5,q6;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
         q1= new Question();
         q2 = new Question();
         q3 = new Question();
         q4 = new Question();
         q5 = new Question();
         q6 = new Question();

        User u1 = new User(); u1.setId(1); u1.setName("mo");
        TextStatus ts = new TextStatus(); ts.setId((short) 1); ts.setName("mo");

    }

    @Test
    public void listInfo(){
        questions = Arrays.asList(q1,q2,q3,q4,q5,q6);
        when(questionService.list()).thenReturn(questions);

        //final ResponseEntity<List<Question>> respons =  questionController.list();
        assertNotNull(questionController.list());
       // assertEquals(200,respons.getStatusCode());
    }
}
