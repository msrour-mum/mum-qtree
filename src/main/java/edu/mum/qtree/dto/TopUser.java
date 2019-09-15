package edu.mum.qtree.dto;

public class TopUser implements Comparable<TopUser>{
    private int id ;
    private String name ;
    private int reputation ;

    public TopUser(int id, String name, int reputation) {
        this.id = id;
        this.name = name;
        this.reputation = reputation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public int compareTo(TopUser o) {
        return o.reputation - this.reputation ;
    }

    @Override
    public String toString() {
        return "TopUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
