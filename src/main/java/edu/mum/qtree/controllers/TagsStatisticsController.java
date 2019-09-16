package edu.mum.qtree.controllers;

import edu.mum.qtree.services.TagsStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Tags Statistics Resourse",description = "Tags Statistics Resourse")
@RestController
public class TagsStatisticsController {

    @Autowired
    private TagsStatisticsService service;

    @ApiOperation(value = "Return List of Popular Tags")
    @GetMapping("/Statistics/popularTags")
    public List<String> getPopularTags(){
        return service.getPopularTags();
    }

    @ApiOperation(value = "Return List of most Active Tags")
    @GetMapping("/Statistics/mostActiveTag")
    public String getMostActiveTag(){
        return service.getMostActiveTage();
    }

}

