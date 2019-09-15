package edu.mum.qtree.models.custom;

import edu.mum.qtree.models.entities.UserRole;

public class UserInfo {

    private int id;
    private String email;
    private String name;
    private String userRole;
    public boolean isEnabled;

    public UserInfo(int id, String email, String name, String userRole, boolean isEnabled)
    {
        setId(id);
        setEmail(email);
        setName(name);
        setIsEnabled(isEnabled);
        setUserRole(userRole);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
