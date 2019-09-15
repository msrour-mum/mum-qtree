package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.UserService;
import edu.mum.qtree.services.UserStatisticsService;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserStatisticsServiceTest {

    private User user1,user2,user3,user4,user5,user6,user7,user8;
    private UserStatisticsService userStatisticsService ;
    private UserService userService;

    public static void main(String[] args) {
        UserStatisticsServiceTest c = new UserStatisticsServiceTest();
        c.setUp() ;
        c.updateUsersReputation();
        c.userStatisticsService.userService = c.userService ;


        System.out.println(c.userStatisticsService.userService.list());


    }
    public  void setUp(){
        user1 = new User();
        user2= new User();
        user3= new User();
        user4= new User();
        user5= new User();
        user6= new User();
        user7= new User();
        user8= new User();

        userStatisticsService = mock(UserStatisticsService.class);
        userService = mock(UserService.class);
    }
    public void updateUsersReputation(){
        when(userStatisticsService.getUserReputationByAnswers(user1)).thenReturn(10);
        when(userStatisticsService.getUserReputationByAnswers(user2)).thenReturn(20);
        when(userStatisticsService.getUserReputationByAnswers(user3)).thenReturn(30);
        when(userStatisticsService.getUserReputationByAnswers(user4)).thenReturn(40);
        when(userStatisticsService.getUserReputationByAnswers(user5)).thenReturn(50);
        when(userStatisticsService.getUserReputationByAnswers(user6)).thenReturn(60);
        when(userStatisticsService.getUserReputationByAnswers(user7)).thenReturn(70);
        when(userStatisticsService.getUserReputationByAnswers(user8)).thenReturn(80);

        when(userStatisticsService.getUserReputationsByQuestions(user1)).thenReturn(10);
        when(userStatisticsService.getUserReputationsByQuestions(user2)).thenReturn(20);
        when(userStatisticsService.getUserReputationsByQuestions(user3)).thenReturn(30);
        when(userStatisticsService.getUserReputationsByQuestions(user4)).thenReturn(40);
        when(userStatisticsService.getUserReputationsByQuestions(user5)).thenReturn(50);
        when(userStatisticsService.getUserReputationsByQuestions(user6)).thenReturn(60);
        when(userStatisticsService.getUserReputationsByQuestions(user7)).thenReturn(70);
        when(userStatisticsService.getUserReputationsByQuestions(user8)).thenReturn(80);

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8);
        when(userService.list()).thenReturn(list);

    }
}
