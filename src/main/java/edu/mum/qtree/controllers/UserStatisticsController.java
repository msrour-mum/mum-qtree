package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopUser;
import edu.mum.qtree.models.custom.ChartItem;
import edu.mum.qtree.services.UserStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.List;

@Api(value = "User Statistics Resourse",description = "User Statistics Resourse")
@RestController
public class UserStatisticsController {

    @Autowired
    private UserStatisticsService service;

    @ApiOperation(value = "Return List of Top Reputated Users")
    @GetMapping("/Statistics/TopReputatedUsers")
    @CrossOrigin(origins = "http://localhost:63342")
    @PermitAll
    public List<TopUser> getTopReputatedUser(){
        return service.getTopReputatedUser();
    }

    @ApiOperation(value = "Return List of Top Active Users")
    @GetMapping("/Statistics/TopActiveUsers")
    @CrossOrigin(origins = "http://localhost:63342")
    @PermitAll
    public List<TopUser> getTopActiveUser(){
        return service.getTopActiveUser();
    }


    @ApiOperation(value = "Return List of Top Active Users")
    @GetMapping("/Statistics/ChartUserQuestion")
    @CrossOrigin(origins = "http://localhost:63342")
    @PermitAll
    public List<ChartItem> ChartUserQuestion(){
        return service.chartUserQuestion();
    }


    @ApiOperation(value = "Return List of Top Active Users")
    @GetMapping("/Statistics/ChartUserAnswer")
    @CrossOrigin(origins = "http://localhost:63342")
    @PermitAll
    public List<ChartItem> ChartUserAnswer(){
        return service.chartUserAnswer();
    }
}
