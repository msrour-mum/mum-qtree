package edu.mum.qtree.services;


import edu.mum.qtree.models.entities.QuestionTags;
import edu.mum.qtree.models.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.jsp.tagext.TagInfo;
import java.util.*;


@Service
public class TagsStatisticsService {

    @Autowired
    private QuestionTagsService qtSer;
    @Autowired
    private TagService tagSer;


    public List<String> getPopularTags(){
        HashMap<Integer,Tag> tagsMap = new HashMap<>();
        List<Integer> queNum = new ArrayList() ;
        List<String> pupularTags = new ArrayList<>();
        if (tagSer.list().size()<2) {
            return pupularTags ;
        }
        for(Tag t : tagSer.list()){
            int numOfQues = 0 ;
            for(QuestionTags qt : qtSer.list()){
                if(t.getId() == qt.getTagId()) numOfQues++ ;
            }
            tagsMap.put(numOfQues,t);
            queNum.add(numOfQues);
        }
        Collections.sort(queNum);
        Collections.reverse(queNum);

        for(int i =0 ; i< queNum.size() && i< 5 ;i++){
            pupularTags.add(tagsMap.get(queNum.get(0)).getName());
        }
        return pupularTags ;
    }

    public String getMostActiveTage(){
        if(getPopularTags().size()<1) return "";
        else return getPopularTags().get(0);
    }

}
