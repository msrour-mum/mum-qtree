package edu.mum.qtree.dto;

import edu.mum.qtree.models.entities.Answer;

import java.util.Collection;

public class ComparableQuestion implements Comparable<ComparableQuestion> {
    private long id ;
    private String text ;
    private Collection<Answer> answers;

    @Override
    public int compareTo(ComparableQuestion o) {
        return o.answers.size() - this.answers.size();
    }

    public ComparableQuestion(long id, String text, Collection<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }
}
