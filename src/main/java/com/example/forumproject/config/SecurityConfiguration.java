package com.example.forumproject.config;

import com.example.forumproject.service.UserForumDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserForumDetailService userForumDetailService;

    public SecurityConfiguration(UserForumDetailService userForumDetailService) {
        this.userForumDetailService = userForumDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userForumDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers("/category/add").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }

}
