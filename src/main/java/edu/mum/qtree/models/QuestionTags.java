package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question_tags", schema = "qtreedb", catalog = "")
public class QuestionTags {
    private int id;
    private Question questionByQuestionId;

    @ManyToOne
    @JoinColumn(name = "question_ID", referencedColumnName = "ID", nullable = false)
    public Question getQuestionByQuestionId() {
        return questionByQuestionId;
    }

    public void setQuestionByQuestionId(Question questionByQuestionId) {
        this.questionByQuestionId = questionByQuestionId;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionTags that = (QuestionTags) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
