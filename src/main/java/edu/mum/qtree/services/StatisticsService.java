package edu.mum.qtree.services;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private UserService userService ;

    public TopUser getTopReputatedUser(){
        int reputation = 0;
        User user = new User() ;
        for (User u : userService.list()){
            if (getusersReputationByAnswers(u) > reputation){
                reputation = getusersReputationByAnswers(u) ;
                user = u ;
            }
        }
        return new TopUser(user.getId(),user.getName(),reputation);
    }
    public TopUser getTopActiveUser(){
        int reputation = 0 ;
        User user = new User();
        for(User u : userService.list()){
            if((getUsersReputationsByQuestions(u))+getusersReputationByAnswers(u)> reputation){
                user = u ;
                reputation = getusersReputationByAnswers(u)+getUsersReputationsByQuestions(u) ;
            }
        }
        return new TopUser(user.getId(),user.getName(),reputation);
    }

    private int getUsersReputationsByQuestions(User user){
        int numOfQuestion = 0;
        for(Question q : user.getQuestions()){
            if(q.getAnswers().size() >= 3) numOfQuestion ++ ;
        }
        return  ((numOfQuestion / 3)*10) ;
    }
    private int getusersReputationByAnswers(User user){
        int numOfAnswers =0 ;
        for (Answer a: user.getAnswers()){
            int positiveVotes =0 ;
            int negativeVotes = 0 ;
            if (a.getVotes().size()>= 3){
                for (Vote v : a.getVotes()){
                    if(v.isLike()) positiveVotes++ ;
                    else negativeVotes++ ;
                }
                if ((positiveVotes / negativeVotes) >= 5) numOfAnswers++ ;
            }
        }
        return ((numOfAnswers/3)*10) ;
    }
}
