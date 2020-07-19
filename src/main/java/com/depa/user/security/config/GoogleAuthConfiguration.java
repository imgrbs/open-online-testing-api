package com.depa.user.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GoogleAuthConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // TODO: make this class only chain google auth.
        httpSecurity
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/","/index.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
