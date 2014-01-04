package com.gridpulse.simpleinsight.domain;

import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author bogdan
 */
@MappedSuperclass
public class MultiTennantDomainObject implements Serializable {

    @ManyToOne
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    
}
