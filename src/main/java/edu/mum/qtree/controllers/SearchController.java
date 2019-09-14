package edu.mum.qtree.controllers;
/*import com.mkyong.model.BaseballCard;
import com.mkyong.service.CardService;
import com.mkyong.service.HibernateSearchService;*/

import edu.mum.qtree.models.entities.Question;
import edu.mum.qtree.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchservice;

    //@Autowired
    //private CardService cardservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Question> search(@RequestParam(value = "search", required = false) String q, Model model) {
       //List<Question> searchResults = null;
        try {
           // cardservice.addCards();
            List<Question>  searchResults = searchservice.fuzzySearch(q);
            return  searchResults;

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
            int x= 0;
        }
       // model.addAttribute("search", searchResults);
       // return "index";
return  null;
    }

}
