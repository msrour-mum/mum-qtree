package edu.mum.qtree.service;

import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.services.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    private UserService service ;
    private int repositoryOldSize  ;
    private int repositoryNewSize  ;

    @Before
    public void before(){
        service = new UserService();
        repositoryOldSize = service.list().size();
        System.out.println("testing adding to Repository");
        System.out.println("Repository size = " +repositoryOldSize) ;
    }
    @Test
    public void updateUserRepo() {
        User u1= new User();
        service.save(u1);
        repositoryNewSize = service.list().size();
        assertEquals(repositoryNewSize,repositoryOldSize+1);
    }
}
