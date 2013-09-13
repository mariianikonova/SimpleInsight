/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.config;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author bogdan
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Resource(name="userDetailsService")
    UserDetailsService userDetailsService;
    
    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**"); // all static assets are unsecured
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // #8
                .loginPage("/login.html")
                .failureUrl("/login.html?failed")
                .permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .logoutSuccessUrl("/login.html?logout")
                .and()
                .authorizeUrls()
                .antMatchers("/index.html").permitAll() // index and login pages are unsecured
                .antMatchers("/meta/**").hasRole("USER")
                .antMatchers("/data/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN");
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
