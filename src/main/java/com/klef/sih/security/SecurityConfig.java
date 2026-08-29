package com.klef.sih.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig 
{

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                // Authentication APIs
                .requestMatchers(
                    "/api/auth/**"
                ).permitAll()

                // Swagger
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // User APIs
                .requestMatchers(
                    "/api/users/**"
                ).permitAll()

                // Disaster - ADMIN only for creating
                .requestMatchers(
                    org.springframework.http.HttpMethod.POST,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                // Disaster - ADMIN only for updating
                .requestMatchers(
                    org.springframework.http.HttpMethod.PUT,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                // Disaster - ADMIN only for deleting
                .requestMatchers(
                    org.springframework.http.HttpMethod.DELETE,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                // Disaster GET APIs - authenticated users
                .requestMatchers(
                    org.springframework.http.HttpMethod.GET,
                    "/api/disasters/**"
                ).authenticated()

                // Everything else requires JWT
                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}