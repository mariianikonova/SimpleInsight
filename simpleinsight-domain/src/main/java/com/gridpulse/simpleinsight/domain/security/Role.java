package com.gridpulse.simpleinsight.domain.security;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bogdan
 */
@Entity
@Table(name = "roles")
public class Role
        implements Serializable {

    public Role() {
    }

    public Role(String roleName) {
        this.name = roleName;
    }
    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Set<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User> userRoles) {
        this.userRoles = userRoles;
    }
}
