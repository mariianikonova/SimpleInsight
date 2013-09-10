/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author bogdan
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin") // #2
                .password("password")
                .roles("ADMIN", "USER");
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
}
