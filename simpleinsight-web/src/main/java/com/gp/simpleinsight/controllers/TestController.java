package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.model.InsightUserDetails;
import com.gp.simpleinsight.repository.UserRepository;
import java.io.PrintWriter;
import java.security.Principal;
import javax.annotation.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
@Transactional
public class TestController {
    
    @Resource UserRepository userRepository;
    
    @RequestMapping("/data/UserInfo")
    @Secured("PERMISSION_QUERY_DATA")
    public void test(Principal user, PrintWriter writer){
        
        writer.write(user.getName() + "\n" );
        for(GrantedAuthority au: 
                (
                ((InsightUserDetails)
                    ((UsernamePasswordAuthenticationToken) user).getPrincipal()
                )).getAuthorities())
        {
            writer.write(au.getAuthority() + "\n");
        }
        
        
    }
    
}
