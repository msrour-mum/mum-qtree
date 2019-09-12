package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Company {
    private int id;
    private String name;
    private Collection<CompanyProfile> companyProfiles;
    private Collection<Job> jobs;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
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

        Company company = (Company) o;

        if (id != company.id) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "company")
    public Collection<CompanyProfile> getCompanyProfiles() {
        return companyProfiles;
    }

    public void setCompanyProfiles(Collection<CompanyProfile> companyProfiles) {
        this.companyProfiles = companyProfiles;
    }

    @OneToMany(mappedBy = "company")
    public Collection<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }
}
