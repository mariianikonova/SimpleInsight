package com.gridpulse.simpleinsight.domain.security;

/**
 * This interface represents the contract between an entity that can behave as an authority and the DTO that
 * will abstract these entities, hiding their implementation from the security layer.
 *
 * @author bogdan
 */
public interface Authority {
    public String getName();
}
