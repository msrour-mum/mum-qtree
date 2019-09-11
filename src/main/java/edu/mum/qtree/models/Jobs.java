package edu.mum.qtree.models;

import javax.persistence.*;

@Entity
public class Jobs {
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

        Jobs jobs = (Jobs) o;

        if (id != jobs.id) return false;
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null) return false;
        if (jobDescritpion != null ? !jobDescritpion.equals(jobs.jobDescritpion) : jobs.jobDescritpion != null)
            return false;
        if (jobType != null ? !jobType.equals(jobs.jobType) : jobs.jobType != null) return false;
        if (jobRole != null ? !jobRole.equals(jobs.jobRole) : jobs.jobRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (jobDescritpion != null ? jobDescritpion.hashCode() : 0);
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (jobRole != null ? jobRole.hashCode() : 0);
        return result;
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
