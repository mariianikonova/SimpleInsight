/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.repository.UserRepository;
import java.io.PrintWriter;
import java.security.Principal;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
public class TestController {
    
    @Resource UserRepository userRepository;
    
    @RequestMapping("/data/UserInfo")
    public void test(Principal user, PrintWriter writer){
        
        userRepository.getUser("admin");
        
        writer.write(user.getName());
        
    }
    
}
