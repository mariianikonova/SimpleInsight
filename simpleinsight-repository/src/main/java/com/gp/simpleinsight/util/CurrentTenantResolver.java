package com.gp.simpleinsight.util;

/**
 *
 * @author bogdan
 */
public interface CurrentTenantResolver<O> {
    O getCurrentTenant();
}
