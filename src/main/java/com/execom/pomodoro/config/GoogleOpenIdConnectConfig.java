///*package com.execom.pomodoro.config;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
//import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//
////import lombok.Value;
//
//@Configuration
//@EnableOAuth2Client
//public class GoogleOpenIdConnectConfig {
//
//    @Value("${google.clientId}")
//    private String clientId;
//
//    @Value("${google.clientSecret}")
//    private String clientSecret;
//
//    @Value("${google.accessTokenUri}")
//    private String accessTokenUri;
//
//    @Value("${google.userAuthorizationUri}")
//    private String userAuthorizationUri;
//
//    @Value("${google.redirectUri}")
//    private String redirectUri;
//
//    @Bean
//    public OAuth2ProtectedResourceDetails googleOpenId() {
//        final AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//        details.setClientId(clientId);
//        details.setClientSecret(clientSecret);
//        details.setAccessTokenUri(accessTokenUri);
//        details.setUserAuthorizationUri(userAuthorizationUri);
//        details.setScope(Arrays.asList("openid", "email"));
//        details.setPreEstablishedRedirectUri(redirectUri);
//        details.setUseCurrentUri(false);
//        return details;
//    }
//
//    @Scope(value="session", proxyMode = ScopedProxyMode.INTERFACES)
//    @Bean
//    public OAuth2RestTemplate googleOpenIdTemplate(final OAuth2ClientContext clientContext) {
//        final OAuth2RestTemplate template = new OAuth2RestTemplate(googleOpenId(), clientContext);
//        return template;
//    }
//}*/