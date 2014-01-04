package com.gp.simpleinsight.util;

import com.gp.simpleinsight.model.InsightUserDetails;
import com.gridpulse.simpleinsight.domain.Organization;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author bogdan
 */
@Component("tenantResolver")
public class SpringSecurityCurrentTenantResolver implements CurrentTenantResolver<Organization> {

    public Organization getCurrentTenant() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ((InsightUserDetails) auth.getPrincipal()).getUser().getOrganization();
    }

}
