/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.populator;

import com.gridpulse.simpleinsight.domain.security.User;
import java.sql.Connection;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.transaction.annotation.Transactional;

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

        em.persist(createUser("admin", "password"));
        em.persist(createUser("user", "password"));

        em.flush();
        em.getTransaction().commit();
        
        if (logger.isInfoEnabled()) {
            logger.info("Finished populating database with default data");
        }

    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    private User createUser(String login, String pass) {
        User adminUser = new User();
        adminUser.setLogin(login);
        adminUser.setPassword(pass);
        return adminUser;
    }
}
