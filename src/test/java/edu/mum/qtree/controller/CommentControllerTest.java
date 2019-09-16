package edu.mum.qtree.controller;

import edu.mum.qtree.controllers.CommentController;
import edu.mum.qtree.models.entities.Comment;
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

public class CommentControllerTest {
    @InjectMocks
    CommentController commentController;
    CommentService commentService = mock(CommentService.class);
    Comment c1 = new Comment();Comment c2 = new Comment();Comment c3 = new Comment();
    Comment c6 = new Comment();Comment c5 = new Comment();Comment c4 = new Comment();
    List<Comment> comments = Arrays.asList(c1,c2,c3,c4,c5,c6);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listInfo(){
        when(commentService.list()).thenReturn(comments) ;

        assertEquals(comments.size(),commentController.list().size());
    }
}
