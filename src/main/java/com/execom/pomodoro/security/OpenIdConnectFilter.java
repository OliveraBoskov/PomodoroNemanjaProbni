/*package com.execom.pomodoro.security;

import static java.util.Optional.empty;
import static org.springframework.security.core.authority.AuthorityUtils.NO_AUTHORITIES;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.execom.pomodoro.domain.UserInfo;

//import lombok.Value;

public class OpenIdConnectFilter extends AbstractAuthenticationProcessingFilter {
    @Value("${google.clientId}")
    private String clientId;

    @Value("${google.issuer}")
    private String issuer;

    @Value("${google.jwkUrl}")
    private String jwkUrl;
    
    @Value("${google.userInfo}")
    private String userInfo;

    @Resource
    public OAuth2RestOperations restTemplate;

    public OpenIdConnectFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authentication -> authentication);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
         
        final ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity(userInfo, UserInfo.class);  
        return new PreAuthenticatedAuthenticationToken(userInfoResponseEntity.getBody(), empty(), NO_AUTHORITIES);
    }
}*/