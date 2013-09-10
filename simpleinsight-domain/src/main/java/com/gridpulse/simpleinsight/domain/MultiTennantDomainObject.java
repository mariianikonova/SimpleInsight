package com.gridpulse.simpleinsight.domain;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author bogdan
 */
public class MultiTennantDomainObject implements Serializable {
    
    @Id private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
}
