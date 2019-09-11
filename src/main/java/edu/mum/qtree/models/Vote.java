package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vote {
    private int id;
    private boolean like;
    private User userByUserId;
    private Answer answerByAnswerId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "like", nullable = false)
    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return id == vote.id &&
                like == vote.like;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, like);
    }

    @ManyToOne
    @JoinColumn(name = "user_ID", referencedColumnName = "ID", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
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
