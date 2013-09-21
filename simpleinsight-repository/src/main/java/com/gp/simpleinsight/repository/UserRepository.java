package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.security.User;

/**
 *
 * @author bogdan
 */
public interface UserRepository {

    public void save(User user);
    public User getUser(String login);
}
