package com.gp.simpleinsight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

/**
 * General application context beans.
 * @author bogdan
 */
@Configuration
public class AppConfig {

    @Bean()
    @Scope(value = "session")
    public String someString() {
        return " ";
    }
    
}