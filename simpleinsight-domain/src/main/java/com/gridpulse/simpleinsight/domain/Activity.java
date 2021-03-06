package com.gridpulse.simpleinsight.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author bogdan
 */
@Entity
public class Activity extends MultiTennantDomainObject implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
