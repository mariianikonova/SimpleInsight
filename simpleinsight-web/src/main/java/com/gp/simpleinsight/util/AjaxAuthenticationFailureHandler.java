package com.gp.simpleinsight.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author bogdan
 */
@Component("failureHandler")
public class AjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        if ("true".equals(request.getHeader("X-Ajax-call"))) {
            response.setHeader("Content-Type", "application/json");
            // FIXME: replace with enum
            response.setStatus(401);
            response.getWriter().print("{'status':'error'}");
            response.getWriter().flush();
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
