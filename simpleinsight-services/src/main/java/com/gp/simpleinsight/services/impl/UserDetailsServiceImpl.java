package com.gp.simpleinsight.services.impl;

import com.gp.simpleinsight.model.InsightUserDetails;
import com.gp.simpleinsight.repository.UserRepository;
import com.gridpulse.simpleinsight.domain.security.User;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bogdan
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

        User user = userRepository.getUser(string);

        InsightUserDetails userDetails = new InsightUserDetails(user);
        

        return userDetails;
    }
}
