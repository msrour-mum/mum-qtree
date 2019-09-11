package edu.mum.qtree.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    private long id;
    private String text;
    private Timestamp creationDate;
    private Answer answerByAnswerId;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Text", nullable = false, length = 500)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "Creation_Date", nullable = false)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (creationDate != null ? !creationDate.equals(comment.creationDate) : comment.creationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "answer_ID", referencedColumnName = "ID", nullable = false)
    public Answer getAnswerByAnswerId() {
        return answerByAnswerId;
    }

    public void setAnswerByAnswerId(Answer answerByAnswerId) {
        this.answerByAnswerId = answerByAnswerId;
    }
}
