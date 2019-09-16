package edu.mum.qtree.controller;

import edu.mum.qtree.controllers.UserController;
import edu.mum.qtree.models.custom.UserInfo;
import edu.mum.qtree.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @InjectMocks
    UserController userController;
    UserService userService= mock(UserService.class);
    @Mock
    UserInfo u1 ;
    @Mock
    UserInfo u2 ;
    @Mock
    UserInfo u3 ;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listUsers(){
        List<UserInfo> list = Arrays.asList(u1,u2,u3);
        when(userService.listInfo()).thenReturn(list);

        assertNotNull(userController.listUsers());
    }
}
