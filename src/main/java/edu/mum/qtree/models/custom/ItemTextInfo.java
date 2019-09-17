package edu.mum.qtree.models.custom;

import edu.mum.qtree.models.entities.Tag;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Collection;

public class ItemTextInfo {
    private  long id;
    private String text;
    private  int userId;
    private  short statusId;
    private String statusName;
    private String userName;
    private Timestamp creationDate;
    private long parentId;

    private Collection<Tag> tags;


    public ItemTextInfo(long id, String text,
                        int userId,short statusId,
                        String userName ,String statusName,
                        Timestamp creationDate , long parentId) {
        this.id = id;
        this.text = text;
        this.userId= userId;
        this.statusId= statusId;
        this.statusName= statusName;
        this.userName= userName;
        this.setCreationDate(creationDate);
        this.setParentId(parentId);
    }

    @Column(name = "ID", nullable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Text", nullable = true)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "User_ID", nullable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "Status_ID", nullable = true)
    public short getStatusId() {
        return statusId;
    }

    public void setStatusId(short statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
}
