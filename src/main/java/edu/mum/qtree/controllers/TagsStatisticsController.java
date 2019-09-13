package edu.mum.qtree.controllers;

import edu.mum.qtree.services.TagsStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebService;
import java.util.List;

@WebService
public class TagsStatisticsController {
    @Autowired
    private TagsStatisticsService service;

    @GetMapping("/Statistics/popularTags")
    public List<String> getPopularTags(){
        return service.getPopularTags();
    }

    @GetMapping("/Statistics/mostActiveTag")
    public String getMostActiveTag(){
        return service.getMostActiveTage();
    }

}
