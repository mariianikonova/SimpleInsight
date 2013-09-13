/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.populator;

import com.gridpulse.simpleinsight.domain.security.Role;
import com.gridpulse.simpleinsight.domain.security.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.init.DatabasePopulator;

/**
 *
 * @author bogdan
 */
public class DefaultDataPopulator implements DatabasePopulator {

    private final static Log logger = LogFactory.getLog(DefaultDataPopulator.class);
    EntityManager em;

    public void populate(Connection cnctn) throws SQLException {

        if (logger.isInfoEnabled()) {
            logger.info("Started populating database with default data");
        }

        em.getTransaction().begin();

        Role adminRole = em.merge(new Role("ROLE_ADMIN"));
        Role userRole = em.merge(new Role("ROLE_USER"));
        
        
        em.persist(createUser("admin", "password", adminRole));
        em.persist(createUser("user", "password", userRole, adminRole));

        em.flush();
        em.getTransaction().commit();

        if (logger.isInfoEnabled()) {
            logger.info("Finished populating database with default data");
        }

    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    private User createUser(String login, String pass, Role... roleNames) {
        User adminUser = new User();
        adminUser.setLogin(login);
        adminUser.setPassword(pass);

        Set<Role> roles = new HashSet<Role>();
        for (Role role : roleNames) {
            roles.add(role);
        }

        adminUser.setRoles(roles);
        return adminUser;
    }
}
