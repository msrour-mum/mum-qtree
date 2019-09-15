package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.services.CommentService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommentServiceTest {


    private CommentService service ;
    private int repositoryOldSize  ;
    private int repositoryNewSize  ;
    @Before
    public void before(){
        service = new CommentService();

        repositoryOldSize = service.list().size();
        System.out.println("testing adding to Repository");
        System.out.println("Repository size = " +repositoryOldSize) ;

    }
    @Test
    public void updateCommentRepo() {
        Comment c1= new Comment();
        service.Add(c1);
        repositoryNewSize = service.list().size();
        assertEquals(repositoryOldSize+1,repositoryNewSize);
    }
}
