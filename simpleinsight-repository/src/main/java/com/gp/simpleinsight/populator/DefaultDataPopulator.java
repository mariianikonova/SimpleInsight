package com.gp.simpleinsight.populator;

import com.gridpulse.simpleinsight.domain.Activity;
import com.gridpulse.simpleinsight.domain.Organization;
import com.gridpulse.simpleinsight.domain.Product;
import com.gridpulse.simpleinsight.domain.ProductLine;
import com.gridpulse.simpleinsight.domain.Project;
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

        Organization org = new Organization("GP", "GridPulse");
        Organization org2 = new Organization("ORG", "Organization");

        em.persist(org);
        em.persist(org2);

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

        em.persist(createUser("admin", "password", "System", "Admin", org2, adminRole, userRole));
        em.persist(createUser("user", "password", "System", "User", org2, userRole));
        em.persist(createUser("bogdan@costea.us", "password", "Bogdan", "Costea", org, orgAdminRole, userRole));

        em.flush();

        Project project = new Project();
        project.setOrganization(org);
        project.setCode("PRJ");
        project.setName("Project");


        Activity activity = new Activity();
        activity.setProject(project);
        activity.setOrganization(org);
        activity.setDescription("A new activity");
        
        em.persist(activity);

        ProductLine superToys = new ProductLine();
        superToys.setName("Super Toys");
        superToys.setDescription("A super toy line");
        superToys.setOrganization(org);
        
        Product superTeddy = new Product();
        superTeddy.setName("Super Teddy");
        superTeddy.setDescription("A super teddybear");
        superTeddy.setProductLine(superToys);
        superTeddy.setOrganization(org);

        em.persist(superToys);
        em.persist(superTeddy);

        em.getTransaction().commit();

        if (logger.isInfoEnabled()) {
            logger.info("Finished populating database with default data");
        }

    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    private User createUser(String login, String pass, String firstName, String lastName, Organization org, Role... roleNames) {
        User user = new User();
        Set<Role> roles = new HashSet<Role>();

        user.setOrganization(org);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(pass);

        roles.addAll(Arrays.asList(roleNames));
        user.setRoles(roles);


        return user;
    }
}
