package edu.mum.qtree.dto;

import edu.mum.qtree.models.entities.Answer;

import java.util.Collection;

public class TopQuestion {
    private long id ;
    private String text ;
    private Collection<Answer> answers;



    public TopQuestion(long id, String text) {
        this.id = id;
        this.text = text;
        this.answers = answers ;
    }

    public long getId() {
        return id;
    }
    public String getText() {
        return text;
    }


}
