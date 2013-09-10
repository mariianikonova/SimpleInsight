/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.controllers;

import java.io.PrintWriter;
import java.security.Principal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
public class TestController {
    
    @RequestMapping("/data/UserInfo")
    public void test(Principal user, PrintWriter writer){
        
        writer.write(user.getName());
        
    }
    
}
