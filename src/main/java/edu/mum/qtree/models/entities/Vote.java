package edu.mum.qtree.models.entities;

import javax.persistence.*;

@Entity
public class Vote {
    private long id;
    private int like;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "User_ID", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Answer.class)
    @JoinColumn(name = "answer_ID", insertable = false, updatable = false)
    private Answer answer;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "like", nullable = false)
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (like != vote.like) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + like;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_ID", referencedColumnName = "ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "answer_ID", referencedColumnName = "ID", nullable = false)
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
