package edu.mum.qtree.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company_profile", schema = "qtreedb", catalog = "")
public class CompanyProfile {
    private int id;
    private String tagValue;
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
    @Column(name = "tag_value", nullable = false, length = 100)
    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyProfile that = (CompanyProfile) o;
        return id == that.id &&
                Objects.equals(tagValue, that.tagValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagValue);
    }

    @ManyToOne
    @JoinColumn(name = "company_ID", referencedColumnName = "ID", nullable = false)
    public Company getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(Company companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }
}
