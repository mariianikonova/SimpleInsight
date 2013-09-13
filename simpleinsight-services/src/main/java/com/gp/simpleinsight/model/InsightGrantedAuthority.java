/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.model;

import com.gridpulse.simpleinsight.domain.security.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author bogdan
 */
public class InsightGrantedAuthority implements GrantedAuthority {

    Role role;

    public InsightGrantedAuthority(Role role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.role.getRole();
    }
}
