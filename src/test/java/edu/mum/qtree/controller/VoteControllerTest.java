package edu.mum.qtree.controller;

import edu.mum.qtree.controllers.CommentController;
import edu.mum.qtree.controllers.VoteController;
import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.models.entities.Vote;
import edu.mum.qtree.services.CommentService;
import edu.mum.qtree.services.VoteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VoteControllerTest  {
    @InjectMocks
    VoteController voteController;
    VoteService voteService = mock(VoteService.class);
    Vote v1 = new Vote();Vote v2 = new Vote();Vote v3 = new Vote();

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void voteList(){
        List<Vote> votes = Arrays.asList(v1,v2,v3);
        when(voteService.list()).thenReturn(votes);
    }
}
