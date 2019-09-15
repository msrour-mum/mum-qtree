package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.services.QuestionService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionServiceTest {
    private QuestionService service ;
    private int repositoryOldSize  ;
    private int repositoryNewSize  ;
    @Before
    public void before(){
        service = new QuestionService();

        repositoryOldSize = service.list().size();
        System.out.println("testing adding to Repository");
        System.out.println("Repository size = " +repositoryOldSize) ;

    }
    @Test
    public void updateQuestionRepo() {
        Question q1= new Question();
        service.Add(q1);
        repositoryNewSize = service.list().size();
        assertEquals(repositoryNewSize,repositoryOldSize+1);
    }
}
