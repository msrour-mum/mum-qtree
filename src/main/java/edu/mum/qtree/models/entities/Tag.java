package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Tag {
    private int id;
    private String name;
    private Collection<QuestionTags> questionTags;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (id != tag.id) return false;
        if (name != null ? !name.equals(tag.name) : tag.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tag")
    public Collection<QuestionTags> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(Collection<QuestionTags> questionTags) {
        this.questionTags = questionTags;
    }
}
