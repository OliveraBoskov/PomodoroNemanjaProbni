package com.execom.pomodoro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import static org.springframework.http.HttpMethod.GET;

import com.execom.pomodoro.security.OpenIdConnectFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String LOGIN_URL = "/api/user";

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint(LOGIN_URL);
    }

    @Bean
    public OpenIdConnectFilter openIdConnectAuthenticationFilter() {
        return new OpenIdConnectFilter(LOGIN_URL);
    }

    @Bean
    public OAuth2ClientContextFilter oAuth2ClientContextFilter() {
        return new OAuth2ClientContextFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(oAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
        .addFilterAfter(openIdConnectAuthenticationFilter(), OAuth2ClientContextFilter.class)
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
        .and().authorizeRequests()
        .antMatchers(GET, "/").permitAll()
        .antMatchers(GET, "/api/user").authenticated();
        //antMathers("nestp/**".aut)
    }
}