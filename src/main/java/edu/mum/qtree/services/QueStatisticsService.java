package edu.mum.qtree.services;

import edu.mum.qtree.dto.ComparableQuestion;
import edu.mum.qtree.dto.TopQuestion;
import edu.mum.qtree.models.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class QueStatisticsService {

    @Autowired
    private QuestionService repo ;

    public TopQuestion getTopQuestion(){
        return getPopularQuestions().get(0);
       }

    public List<TopQuestion> getPopularQuestions(){
        List<ComparableQuestion> ques = new ArrayList<>();
        for(Question e : repo.list()){
            ques.add(new ComparableQuestion(e.getId(),e.getText(),e.getAnswers())) ;

        }
        Collections.sort(ques);
        List<TopQuestion> questions = new ArrayList<>() ;
        if (ques.size() > 5){
            for(int i = 0; i < ques.size() && i < 5 ;i++ ){
                questions.add(new TopQuestion(ques.get(i).getId(),ques.get(i).getText()));
            }
        }
        return questions ;
    }
}
