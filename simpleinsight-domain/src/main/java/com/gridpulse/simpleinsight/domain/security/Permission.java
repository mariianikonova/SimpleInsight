package com.gridpulse.simpleinsight.domain.security;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * A permission represents a right that can be granted to a user. The permission can depict simple concepts
 * like the user right to view an UI module or complex rights like the user right to write a specific entity.
 * Permission naming should be done consistently, for example: General permissions should start with
 * PERMISSION_ while UI permissions should start with UI_PERMISSION_.
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
