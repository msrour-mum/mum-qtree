package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Job {
    private int id;
    private String jobTitle;
    private String jobDescritpion;
    private String jobType;
    private String jobRole;
    private Company companyByCompanyId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Job_Title", nullable = true, length = 45)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "Job_Descritpion", nullable = true, length = 2000)
    public String getJobDescritpion() {
        return jobDescritpion;
    }

    public void setJobDescritpion(String jobDescritpion) {
        this.jobDescritpion = jobDescritpion;
    }

    @Basic
    @Column(name = "Job_Type", nullable = true, length = 45)
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "Job_Role", nullable = true, length = 500)
    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                Objects.equals(jobTitle, job.jobTitle) &&
                Objects.equals(jobDescritpion, job.jobDescritpion) &&
                Objects.equals(jobType, job.jobType) &&
                Objects.equals(jobRole, job.jobRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle, jobDescritpion, jobType, jobRole);
    }

    @ManyToOne
    @JoinColumn(name = "Company_ID", referencedColumnName = "ID", nullable = false)
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
}
