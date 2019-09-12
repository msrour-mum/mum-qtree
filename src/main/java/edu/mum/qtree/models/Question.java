package edu.mum.qtree.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Question {
    private long id;
    private String text;
    private Timestamp creationDate;
    private short statusId;
    private int userId;
    private Collection<Answer> answersById;
    private Collection<QuestionTags> questionTagsById;

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

    @Basic
    @Column(name = "Status_ID", nullable = false)
    public short getStatusId() {
        return statusId;
    }

    public void setStatusId(short statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "User_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                statusId == question.statusId &&
                userId == question.userId &&
                Objects.equals(text, question.text) &&
                Objects.equals(creationDate, question.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, creationDate, statusId, userId);
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<Answer> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<Answer> answersById) {
        this.answersById = answersById;
    }

    @OneToMany(mappedBy = "questionByQuestionId")
    public Collection<QuestionTags> getQuestionTagsById() {
        return questionTagsById;
    }

    public void setQuestionTagsById(Collection<QuestionTags> questionTagsById) {
        this.questionTagsById = questionTagsById;
    }
}
