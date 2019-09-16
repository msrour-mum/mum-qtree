package edu.mum.qtree.service;

import edu.mum.qtree.dto.TopQuestion;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.services.QueStatisticsService;
import edu.mum.qtree.services.QuestionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


public class QueStatisticsServiceTest {

    Question q1,q2,q3,q4,q5,q6 ;
    TopQuestion tq4,tq5;
    QuestionService qs ;
    QueStatisticsService q ;

    @Before
    public void beforeTest() {
        q = new QueStatisticsService();
        setUp();
        q.repo = qs ;
        tq4 = new TopQuestion(4,"q4");
        tq5 = new TopQuestion(5, "q5");
//        System.out.println(q.getPopularQuestions());
//        System.out.println(q.getTopQuestion());

    }

    @Test
    public void testPopular(){
         assertEquals((q.getPopularQuestions().get(0)).getId(),tq4.getId());
        assertEquals((q.getPopularQuestions().get(q.getPopularQuestions().size()-1)).getId(),tq5.getId());

    }
    @Test
    public void testTopQuestion(){
        assertEquals(q.getTopQuestion().getId(),tq4.getId());
    }
    public void setUp(){
         q1 = new Question();
         q2 = new Question();
         q3 = new Question();
         q4 = new Question();
         q5 = new Question();
         q6 = new Question();

        Answer a1 = new Answer();
        Answer a2 = new Answer();
        Answer a3 = new Answer();
        Answer a4 = new Answer();
        List<Answer> ans1 = Arrays.asList(a1,a2);
        List<Answer> ans2 = Arrays.asList(a1,a2,a3);
        List<Answer> ans3 = Arrays.asList(a1,a2,a3,a4);
        List<Answer> ans4 = Arrays.asList(a1,a2,a1,a2,a3,a4,a1);
        List<Answer> ans5 = Arrays.asList(a1,a2,a3,a2,a3);
        List<Answer> ans6 = Arrays.asList(a1,a2,a3,a4,a2,a3);

        q1.setId(1);q1.setText("q1");q1.setAnswers(ans1);
        q2.setId(2);q1.setText("q2");q2.setAnswers(ans2);
        q3.setId(3);q1.setText("q3");q3.setAnswers(ans3);
        q4.setId(4);q4.setText("q4");q4.setAnswers(ans4);
        q5.setId(5);q5.setText("q5");q5.setAnswers(ans5);
        q6.setId(6);q6.setText("q6");q6.setAnswers(ans6);


        List<Question> list = Arrays.asList(q1,q2,q3,q4,q5,q6);
        qs = mock(QuestionService.class) ;
        when(qs.list()).thenReturn(list);
    }

}
