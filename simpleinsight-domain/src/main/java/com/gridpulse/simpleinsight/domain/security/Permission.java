package com.gridpulse.simpleinsight.domain.security;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author bogdan
 */

@Entity
@Table(name = "permissions")
public class Permission implements Serializable, Authority {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;

    @ManyToMany(mappedBy="permissions")
    private Set<Role> roles;

    public Permission(){}
    public Permission(String name) {
        this.name=name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
