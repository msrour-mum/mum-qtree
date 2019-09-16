package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.UserService;
import edu.mum.qtree.services.UserStatisticsService;
import edu.mum.qtree.utility.UserStatisticsHelper;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserStatisticsServiceTest {

    private User user1,user2,user3,user4,user5,user6;
    private UserStatisticsHelper helper;
    private UserService userService;

    public static void main(String[] args) {
        UserStatisticsServiceTest c = new UserStatisticsServiceTest();
        c.setUp() ;
        c.updateUsersReputation();

        UserStatisticsService userStatisticsService = new UserStatisticsService();
        userStatisticsService.userService = c.userService ;
        userStatisticsService.uHelper = c.helper;

        System.out.println(userStatisticsService.getTopReputatedUser());
        System.out.println(userStatisticsService.getTopActiveUser());
    }
    public  void setUp(){
        user1 = new User();
        user1.setId(1);user1.setName("user1");
        user2= new User();
        user2.setId(2);user2.setName("user2");
        user3= new User();
        user3.setId(3);user3.setName("user3");
        user4= new User();
        user4.setId(4);user4.setName("user4");
        user5= new User();
        user5.setId(5);user5.setName("user5");
        user6= new User();
        user6.setId(6);user6.setName("user6");

        helper =mock(UserStatisticsHelper.class);
        userService = mock(UserService.class);

    }
    public void updateUsersReputation(){

        when(helper.getUserReputationByAnswers(user1)).thenReturn(10);
        when(helper.getUserReputationsByQuestions(user1)).thenReturn(5);

        when(helper.getUserReputationByAnswers(user2)).thenReturn(20);
        when(helper.getUserReputationsByQuestions(user2)).thenReturn(10);

        when(helper.getUserReputationByAnswers(user3)).thenReturn(30);
        when(helper.getUserReputationsByQuestions(user3)).thenReturn(15);

        when(helper.getUserReputationByAnswers(user4)).thenReturn(40);
        when(helper.getUserReputationsByQuestions(user1)).thenReturn(20);

        when(helper.getUserReputationByAnswers(user5)).thenReturn(50);
        when(helper.getUserReputationsByQuestions(user5)).thenReturn(25);

        when(helper.getUserReputationByAnswers(user6)).thenReturn(60);
        when(helper.getUserReputationsByQuestions(user6)).thenReturn(30);

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6);
        when(userService.list()).thenReturn(list);

    }
}
