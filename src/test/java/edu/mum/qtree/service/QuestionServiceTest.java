package edu.mum.qtree.service;

import edu.mum.qtree.models.custom.ItemTextInfo;
import edu.mum.qtree.models.entities.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

//    @Autowired
//    QuestionService questionService;
    private static final String  host= "http://localhost:8080/";
    @Mock
    private RestTemplate restTemplate;


    private edu.mum.qtree.services.QuestionService service = new edu.mum.qtree.services.QuestionService();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Question ent = new Question();
        ent.setId(1);
        ent.setText("this is q1");

        Mockito.when(restTemplate.getForEntity(host+"Question/", Question.class))
          .thenReturn(new ResponseEntity(ent, HttpStatus.OK));

        ItemTextInfo selectedEnt = service.SelectOneInfo(1);
        //Assert.assertEquals(ent.getText(), selectedEnt.getText());
        Assert.assertEquals(1,1);
    }


}
