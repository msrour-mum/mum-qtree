package edu.mum.qtree.models.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class User implements UserDetails {
    private int id;
    private String email;
    private String name;
    private String password;
    private byte isEnabled;
    private Date createdOn;
    private Date modifiedOn;
    private Collection<Answer> answers;
    private Collection<Comment> comments;
    private Collection<Question> questions;
    private UserRole userRole;
    private Collection<UserCommunity> userCommunities;
    private Collection<UserJobs> userJobs;
    private Collection<Vote> votes;

    private List<String> roles = new ArrayList<>();

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {

        this.roles.add(getUserRole().getName());
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 250)
    public String getPassword() {
        return password;
    }

    @Override
    @Transient
    public String getUsername() {
        return getEmail();
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return  true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Is_Enabled", nullable = false)
    public byte getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(byte isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Basic
    @Column(name = "created_on", nullable = false)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "modified_on", nullable = false)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isEnabled != user.isEnabled) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (createdOn != null ? !createdOn.equals(user.createdOn) : user.createdOn != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(user.modifiedOn) : user.modifiedOn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) isEnabled;
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    @ManyToOne
    @JoinColumn(name = "User_Role_ID", referencedColumnName = "ID", nullable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<UserCommunity> getUserCommunities() {
        return userCommunities;
    }

    public void setUserCommunities(Collection<UserCommunity> userCommunities) {
        this.userCommunities = userCommunities;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<UserJobs> getUserJobs() {
        return userJobs;
    }

    public void setUserJobs(Collection<UserJobs> userJobs) {
        this.userJobs = userJobs;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }
}
