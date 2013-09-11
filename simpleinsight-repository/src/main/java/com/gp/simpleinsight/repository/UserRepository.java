/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.security.User;

/**
 *
 * @author bogdan
 */
public interface UserRepository {

    public User getUser(String login);
}
