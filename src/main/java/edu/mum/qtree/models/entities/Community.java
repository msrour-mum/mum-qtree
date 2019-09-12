package edu.mum.qtree.models.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Community {
    private int id;
    private String name;
    private Collection<UserCommunity> userCommunities;

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

        Community community = (Community) o;

        if (id != community.id) return false;
        if (name != null ? !name.equals(community.name) : community.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "community")
    public Collection<UserCommunity> getUserCommunities() {
        return userCommunities;
    }

    public void setUserCommunities(Collection<UserCommunity> userCommunities) {
        this.userCommunities = userCommunities;
    }
}
