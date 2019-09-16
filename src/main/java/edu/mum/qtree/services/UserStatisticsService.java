package edu.mum.qtree.services;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.models.entities.Answer;
import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserStatisticsService {

    @Autowired
    private UserService userService ;

    public List<TopUser> getTopReputatedUser(){
        List<TopUser> users = new ArrayList<>();
        int reputation = 0;
        for (User u : userService.list()){
            reputation = getUserReputationByAnswers(u);
            users.add(new TopUser(u.getId(),u.getName(),reputation));
        }
        Collections.sort(users);
        Collections.reverse(users);
        List<TopUser> updatedUsers = new ArrayList<>();
            for(int i =0 ; i < 5 && i<users.size() ;i++){
                updatedUsers.add(users.get(i));
            }
        return updatedUsers;
    }
    public List<TopUser> getTopActiveUser(){
        List<TopUser> users = new ArrayList<>();
        int reputation = 0;
        for (User u : userService.list()){
            reputation = getUserReputationByAnswers(u) + getUserReputationsByQuestions(u);
            users.add(new TopUser(u.getId(),u.getName(),reputation));
        }
        Collections.sort(users);
        Collections.reverse(users);
        List<TopUser> updatedUsers = new ArrayList<>();
        for(int i =0 ; i < 5 && i<users.size() ;i++){
            updatedUsers.add(users.get(i));
        }
        return updatedUsers;
    }

    private int getUserReputationsByQuestions(User user){
        int numOfQuestion = 0;
        for(Question q : user.getQuestions()){
            if(q.getAnswers().size() >= 3) numOfQuestion ++ ;
        }
        return  ((numOfQuestion / 3)*10) ;
    }
    private int getUserReputationByAnswers(User user){
        int numOfAnswers =0 ;
        for (Answer a: user.getAnswers()){
            int positiveVotes =0 ;
            int negativeVotes = 0 ;
            if (a.getVotes().size()>= 3){
                for (Vote v : a.getVotes()){
                    if(v.getLike()>0) positiveVotes++ ;
                    else negativeVotes++ ;
                }
                if ((positiveVotes / negativeVotes) >= 5) numOfAnswers++ ;
            }
        }
        return ((numOfAnswers/3)*10) ;
    }
}
