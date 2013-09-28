package com.gp.simpleinsight.populator;

import com.gridpulse.simpleinsight.domain.security.Permission;
import com.gridpulse.simpleinsight.domain.security.Role;
import com.gridpulse.simpleinsight.domain.security.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
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

        Permission queryDataPermission = new Permission("PERMISSION_QUERY_DATA");

        Permission manageOrgPermission = new Permission("PERMISSION_MANAGE_ORGANISATION");

        em.persist(manageOrgPermission);
        em.persist(queryDataPermission);

        Role adminRole = new Role("ROLE_ADMIN");

        Role orgAdminRole = new Role("ROLE_ORG_ADMIN");
        orgAdminRole.getPermissions().add(manageOrgPermission);

        Role userRole = new Role("ROLE_USER");
        userRole.getPermissions().add(queryDataPermission);

        em.persist(adminRole);
        em.persist(orgAdminRole);
        em.persist(userRole);

        em.persist(createUser("admin", "password", "System", "Admin", adminRole, userRole));
        em.persist(createUser("user", "password", "System", "User", userRole));
        em.persist(createUser("bogdan@costea.us", "password", "Bogdan", "Costea", orgAdminRole, userRole));

        em.flush();
        em.getTransaction().commit();

        if (logger.isInfoEnabled()) {
            logger.info("Finished populating database with default data");
        }

    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    private User createUser(String login, String pass, String firstName, String lastName, Role... roleNames) {
        User user = new User();
        Set<Role> roles = new HashSet<Role>();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(pass);

        roles.addAll(Arrays.asList(roleNames));
        user.setRoles(roles);

        return user;
    }
}
