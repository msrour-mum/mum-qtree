package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.services.UserStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User Statistics Resourse",description = "User Statistics Resourse")
@RestController
public class UserStatisticsController {

    @Autowired
    private UserStatisticsService service;

    @ApiOperation(value = "Return List of Top Reputated Users")
    @GetMapping("/Statistics/TopReputatedUsers")
    public List<TopUser> getTopReputatedUser(){
        return service.getTopReputatedUser();
    }

    @ApiOperation(value = "Return List of Top Active Users")
    @GetMapping("/Statistics/TopActiveUsers")
    public List<TopUser> getTopActiveUser(){
        return service.getTopActiveUser();
    }
}
