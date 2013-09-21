package com.gp.simpleinsight.model;

import com.gridpulse.simpleinsight.domain.security.Authority;
import com.gridpulse.simpleinsight.domain.security.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author bogdan
 */
public class InsightGrantedAuthority implements GrantedAuthority {

    Authority authority;

    public InsightGrantedAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority.getName();
    }
}
