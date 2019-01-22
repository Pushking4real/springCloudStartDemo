package com.abchina.eureka.cluster.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

   // private static Logger log = (Logger) LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	super.configure(http);
        http.csrf().disable().httpBasic();
    }


}
