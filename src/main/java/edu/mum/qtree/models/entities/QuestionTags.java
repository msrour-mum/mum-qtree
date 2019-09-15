package edu.mum.qtree.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "question_tags", schema = "qtreedb", catalog = "")
public class QuestionTags {
    private int id;
    private long questionId;
    private int tagId;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "question_ID", nullable = false)
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "tag_ID", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionTags that = (QuestionTags) o;

        if (id != that.id) return false;
        if (questionId != that.questionId) return false;
        if (tagId != that.tagId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) (questionId ^ (questionId >>> 32));
        result = 31 * result + tagId;
        return result;
    }
}
