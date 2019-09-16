package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopQuestion;
import edu.mum.qtree.services.QueStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Question Statistics Resourse",description = "Question Statistics Resourse")
@RestController
public class QuestionStatisticsController {


    @Autowired
    private QueStatisticsService service;

    @ApiOperation(value = "Return List of Top Questions")
    @GetMapping("/Statistics/TopQuestion")
    public TopQuestion getTopQuestion(){ return service.getTopQuestion(); }

    @ApiOperation(value = "Return List of Popular Questions")
    @GetMapping("/Statistics/PopularQuestions")
    public List<TopQuestion> getPopularQuestions() { return service.getPopularQuestions(); }

}
