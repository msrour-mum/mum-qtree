package edu.mum.qtree.controller;

import edu.mum.qtree.controllers.AnswerController;
import edu.mum.qtree.controllers.CommentController;
import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.services.AnswerService;
import edu.mum.qtree.services.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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


    @Mock
    ItemTextInfo i1;
    @Mock
    ItemTextInfo i2;
    @Mock
    ItemTextInfo i3;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void list(){
        List<ItemTextInfo> items = Arrays.asList(i1,i2,i3);
        when(answerService.ListInfo()).thenReturn(items);
        assertEquals(items.size(),answerController.listInfo().size());
    }
}
