package edu.mum.qtree.models.custom;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "question")

public class ItemSearchResult {
    //@Field
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  long itemId;
    @Field(termVector = TermVector.YES)
    private String name;

    public String getTxt() {
        return name;
    }

    @Basic
    @Column(name = "Text", nullable = true, length = 500)
    public void setTxt(String txt) {
        this.name = txt;
    }


    @Id
    @Column(name = "ID", nullable = true)
    public long getId() {
        return itemId;
    }

    public void setId(long id) {
        this.itemId = id;
    }
}
