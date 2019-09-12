package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company_profile_type", schema = "qtreedb", catalog = "")
public class CompanyProfileType {
    private short id;
    private String name;

    @Id
    @Column(name = "Id", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
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
        CompanyProfileType that = (CompanyProfileType) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
