package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.Comment;
import edu.mum.qtree.services.CommentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService service ;

    @Test
    public void updateCommentRepo() {

        assertEquals(0,service.list().size());
    }
}
