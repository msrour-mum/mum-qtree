package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.services.UserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserStatisticsController {

    @Autowired
    private UserStatisticsService service;

    @GetMapping("/Statistics/TopReputatedUsers")
    public List<TopUser> getTopReputatedUser(){
        return service.getTopReputatedUser();
    }

    @GetMapping("/Statistics/TopActiveUsers")
    public List<TopUser> getTopActiveUser(){
        return service.getTopActiveUser();
    }
}
