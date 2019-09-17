package edu.mum.qtree.models.custom;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

public class ChartItem {


    public ChartItem(String name , int itemNumber)
    {
        this.itemNumber=itemNumber;
        this.name=name;
    }
    //@Field
    private  int itemNumber;
    private String name;


    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
