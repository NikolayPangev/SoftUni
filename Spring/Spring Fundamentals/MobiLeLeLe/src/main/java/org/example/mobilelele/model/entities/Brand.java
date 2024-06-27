package org.example.mobilelele.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private Date created;

    @Column
    private Date modified;

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
