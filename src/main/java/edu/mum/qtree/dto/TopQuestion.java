package edu.mum.qtree.dto;

import edu.mum.qtree.models.entities.Answer;

import java.util.Collection;

public class TopQuestion {
    private long id ;
    private String text ;



    public TopQuestion(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TopQuestion{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
