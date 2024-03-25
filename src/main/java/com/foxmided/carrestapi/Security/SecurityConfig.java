package com.foxmided.carrestapi.Security;

import com.auth0.AuthenticationController;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    public static class NoSecurityConfigurer {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().permitAll()
                    .and()
                    .csrf().disable(); //CSRF

            return http.build();
        }
    }

//  @Value(value = "${spring.auth0.domain}")
//  private String domain;
//
//  @Value(value = "${spring.auth0.clientId}")
//  private String clientId;
//
//  @Value(value = "${spring.auth0.clientSecret}")
//  private String clientSecret;
//
//  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//  private String issuer;
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//            .authorizeRequests()
//            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            .and()
//            .logout()
//            .and()
//            .oauth2ResourceServer()
//            .jwt().decoder(jwtDecoder());
//    return http.build();
//  }
//  @Bean
//  public AuthenticationController authenticationController() throws UnsupportedEncodingException {
//    JwkProvider jwkProvider = new JwkProviderBuilder(domain).build();
//    return AuthenticationController.newBuilder(domain, clientId, clientSecret)
//            .withJwkProvider(jwkProvider)
//            .build();
//  }
//
//  public String getManagementApiToken() {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//
//    JSONObject requestBody = new JSONObject();
//    requestBody.put("client_id", "auth0ManagementAppClientId");
//    requestBody.put("client_secret", "auth0ManagementAppClientSecret");
//    requestBody.put("audience", "https://dev-example.auth0.com/api/v2/");
//    requestBody.put("grant_type", "client_credentials");
//
//    HttpEntity<String> request = new HttpEntity<String>(requestBody.toString(), headers);
//
//    RestTemplate restTemplate = new RestTemplate();
//    HashMap<String, String> result = restTemplate
//            .postForObject("https://dev-example.auth0.com/oauth/token", request, HashMap.class);
//
//    return result.get("access_token");
//  }
//
//  JwtDecoder jwtDecoder() {
//    OAuth2TokenValidator<Jwt> withAudience = (OAuth2TokenValidator<Jwt>) new SecurityConfig();
//    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
//    OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);
//
//    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
//    jwtDecoder.setJwtValidator(validator);
//    return jwtDecoder;
//  }
//
//  public String getClientId() {
//    return clientId;
//  }
}