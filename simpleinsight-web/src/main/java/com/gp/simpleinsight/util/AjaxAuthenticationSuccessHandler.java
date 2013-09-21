package com.gp.simpleinsight.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author bogdan
 */
@Component("successHandler")
public class AjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
    
            if ("true".equals(request.getHeader("X-Ajax-call"))) {
                response.setHeader("Content-Type", "application/json");
                response.getWriter().print("{'status':'ok'}");
                response.getWriter().flush();
            } else {
                super.onAuthenticationSuccess(request, response, auth);
            }
    
    }
}
