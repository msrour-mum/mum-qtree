package edu.mum.qtree.controller;

import edu.mum.qtree.controllers.AnswerController;
import edu.mum.qtree.controllers.CommentController;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.custom.ItemTextRequest;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.services.AnswerService;
import edu.mum.qtree.services.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerControllerTest {
    @InjectMocks
    AnswerController answerController;
    AnswerService answerService = mock(AnswerService.class);

    Answer a1 = new Answer();Answer a2 = new Answer();Answer a3 = new Answer();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void list(){
        List<Answer> answers = Arrays.asList(a1,a2,a3);
        when(answerService.list()).thenReturn(answers);
        assertEquals(answers.size(),answerController.listInfo().size());
    }
}
