package edu.mum.qtree.models.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    private long id;
    private String text;
    private Timestamp creationDate;
    private TextStatus textStatus;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "User_ID", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Answer.class)
    @JoinColumn(name = "answer_ID", insertable = false, updatable = false)
    private Answer answers;

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
    @JoinColumn(name = "Status_ID", referencedColumnName = "ID", nullable = false)
    public TextStatus getTextStatus() {
        return textStatus;
    }

    public void setTextStatus(TextStatus textStatus) {
        this.textStatus = textStatus;
    }

    @ManyToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "answer_ID", referencedColumnName = "ID", nullable = false)
    public Answer getAnswers() {
        return answers;
    }

    public void setAnswers(Answer answers) {
        this.answers = answers;
    }
}
