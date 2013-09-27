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
    public Map<String, Map<String, Object>> getClientConfig(Principal principal) {
        Map<String, Map<String, Object>> config = new HashMap<String, Map<String, Object>>();

        InsightUserDetails userDetails = (InsightUserDetails) userDetailsService.loadUserByUsername(principal.getName());

        config.put("user", getUserDetailsMap(userDetails));

        return config;
    }

    private Map<String, Object> getUserDetailsMap(InsightUserDetails userDetails) {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("username", userDetails.getUsername());
        user.put("displayName", userDetails.getDisplayName());

        user.put("emailHash", userDetails.getEmailHash());
        user.put("grantedAuthorities", userDetails.getAuthorities());
        return user;
    }

}
