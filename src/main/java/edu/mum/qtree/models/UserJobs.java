package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_jobs", schema = "qtreedb", catalog = "")
public class UserJobs {
    private int id;
    private byte isApplied;
    private byte isSaved;
    private int rate;
    private Job jobByJobId;
    private User userByUserId;

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
        return id == userJobs.id &&
                isApplied == userJobs.isApplied &&
                isSaved == userJobs.isSaved &&
                rate == userJobs.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isApplied, isSaved, rate);
    }

    @ManyToOne
    @JoinColumn(name = "Job_ID", referencedColumnName = "ID", nullable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
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
