package edu.mum.qtree.models.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user_role", schema = "qtreedb", catalog = "")
public class UserRole {
    private int id;
    private String name;
    private Collection<User> users;

    public UserRole()
    {

    }

    public UserRole(int roleId)
    {
        setId(roleId);
    }
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 45)
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

        UserRole userRole = (UserRole) o;

        if (id != userRole.id) return false;
        if (name != null ? !name.equals(userRole.name) : userRole.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY)
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
