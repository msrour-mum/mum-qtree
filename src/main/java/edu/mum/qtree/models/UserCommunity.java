package edu.mum.qtree.models;

import javax.persistence.*;

@Entity
@Table(name = "user_community", schema = "qtreedb", catalog = "")
public class UserCommunity {
    private int id;
    private Community communityByCommunityId;
    private User userByUserId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCommunity that = (UserCommunity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "Community_ID", referencedColumnName = "ID", nullable = false)
    public Community getCommunityByCommunityId() {
        return communityByCommunityId;
    }

    public void setCommunityByCommunityId(Community communityByCommunityId) {
        this.communityByCommunityId = communityByCommunityId;
    }

    @ManyToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
