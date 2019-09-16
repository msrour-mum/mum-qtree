package edu.mum.qtree.service;

import edu.mum.qtree.exceptions.BusinessException;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service ;

    @Before
    public void before()  {
        System.out.println("testing retreving user");
    }
    @Test
    public void updateUserRepo() {

        assertEquals(service.list().size(),37);
    }
}
