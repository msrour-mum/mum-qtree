package edu.mum.qtree.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_jobs", schema = "qtreedb", catalog = "")
public class UserJobs {
    private int id;
    private byte isApplied;
    private byte isSaved;
    private int rate;
    private Job job;
    private User user;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Is_Applied", nullable = false)
    public byte getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(byte isApplied) {
        this.isApplied = isApplied;
    }

    @Basic
    @Column(name = "Is_Saved", nullable = false)
    public byte getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(byte isSaved) {
        this.isSaved = isSaved;
    }

    @Basic
    @Column(name = "Rate", nullable = false)
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserJobs userJobs = (UserJobs) o;

        if (id != userJobs.id) return false;
        if (isApplied != userJobs.isApplied) return false;
        if (isSaved != userJobs.isSaved) return false;
        if (rate != userJobs.rate) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) isApplied;
        result = 31 * result + (int) isSaved;
        result = 31 * result + rate;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Job_ID", referencedColumnName = "ID", nullable = false)
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @ManyToOne
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
