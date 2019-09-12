package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "company_profile_type", schema = "qtreedb", catalog = "")
public class CompanyProfileType {
    private short id;
    private String name;
    private Collection<CompanyProfile> companyProfiles;

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

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "companyProfileType")
    public Collection<CompanyProfile> getCompanyProfiles() {
        return companyProfiles;
    }

    public void setCompanyProfiles(Collection<CompanyProfile> companyProfiles) {
        this.companyProfiles = companyProfiles;
    }
}
