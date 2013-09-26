package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.model.InsightUserDetails;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bogdan
 */
@Controller
public class ClientConfigController {

    @Resource(name = "userDetailsService")
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/api/config", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getClientConfig(Principal principal) {
        Map<String, Object> config = new HashMap<String, Object>();

        InsightUserDetails userDetails = (InsightUserDetails) userDetailsService.loadUserByUsername(principal.getName());
        config.put("username", userDetails.getUsername());
        config.put("emailhash", userDetails.getEmailHash());
        config.put("grantedAuthorities", userDetails.getAuthorities());

        return config;
    }

}
