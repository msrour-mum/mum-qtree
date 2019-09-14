package edu.mum.qtree.controllers;

import edu.mum.qtree.dto.TopQuestion;
import edu.mum.qtree.services.QueStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionStatisticsController {

    @Autowired
    private QueStatisticsService service;


    @GetMapping("/Statistics/TopQuestion")
    public TopQuestion getTopQuestion(){ return service.getTopQuestion(); }

    @GetMapping("/Statistics/PopularQuestions")
    public List<TopQuestion> getPopularQuestions() { return service.getPopularQuestions(); }

}
