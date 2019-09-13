package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStatisticsController {

    @Autowired
    private StatisticsService service;

    @GetMapping("/Statistics/TopReputatedUser")
    public TopUser getTopReputatedUser(){
        return service.getTopReputatedUser();
    }
    @GetMapping("/Statistics/TopActiveUser")
    public TopUser getTopActiveUser(){
        return service.getTopActiveUser();
    }
}
