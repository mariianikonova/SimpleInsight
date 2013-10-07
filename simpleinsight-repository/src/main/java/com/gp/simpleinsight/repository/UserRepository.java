package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bogdan
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUser(String login);
}
