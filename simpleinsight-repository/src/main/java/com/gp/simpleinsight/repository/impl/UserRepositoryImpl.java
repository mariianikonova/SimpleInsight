package com.gp.simpleinsight.repository.impl;

import com.gp.simpleinsight.repository.UserRepository;
import com.gridpulse.simpleinsight.domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bogdan
 */
@Repository
public class UserRepositoryImpl extends AbstractRepository<User>
        implements UserRepository {


    public User getUser(String login) {
        List<User> userList = new ArrayList<User>();

        Query query = getEntityManager().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.getResultList();

        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }
}
