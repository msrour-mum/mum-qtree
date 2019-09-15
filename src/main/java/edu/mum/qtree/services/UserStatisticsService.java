package edu.mum.qtree.services;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.utility.UserStatisticsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserStatisticsService {

    @Autowired
    public UserService userService ;

    public UserStatisticsHelper uHelper = new UserStatisticsHelper() ;

    public List<TopUser> getTopReputatedUser(){
        List<TopUser> users = new ArrayList<>();
        int reputation = 0;
        for (User u : userService.list()){
            reputation = uHelper.getUserReputationByAnswers(u);
            users.add(new TopUser(u.getId(),u.getName(),reputation));
        }
        Collections.sort(users);
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
            reputation = uHelper.getUserReputationByAnswers(u) + uHelper.getUserReputationsByQuestions(u);
            users.add(new TopUser(u.getId(),u.getName(),reputation));
        }
        Collections.sort(users);
        List<TopUser> updatedUsers = new ArrayList<>();
        for(int i =0 ; i < 5 && i<users.size() ;i++){
            updatedUsers.add(users.get(i));
        }
        return updatedUsers;
    }



}
