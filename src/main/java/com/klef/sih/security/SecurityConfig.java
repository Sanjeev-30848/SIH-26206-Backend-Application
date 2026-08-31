package com.klef.sih.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

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
            AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:5173",
                "http://localhost:2026"
        ));

        configuration.setAllowedMethods(Arrays.asList(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
        ));

        configuration.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type",
                "Accept"
        ));

        configuration.setExposedHeaders(Arrays.asList(
                "Authorization"
        ));

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .cors(cors -> cors.configurationSource(
                    corsConfigurationSource()
            ))

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                    HttpMethod.OPTIONS,
                    "/**"
                ).permitAll()

                .requestMatchers(
                    "/api/auth/**"
                ).permitAll()

                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

              
                .requestMatchers(
                    "/api/users/**"
                ).permitAll()

             
                .requestMatchers(
                    HttpMethod.POST,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/disasters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/disasters/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.POST,
                    "/api/alerts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/alerts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/alerts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/alerts/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.POST,
                    "/api/shelters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/shelters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/shelters/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/shelters/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.POST,
                    "/api/emergency-contacts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/emergency-contacts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/emergency-contacts/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/emergency-contacts/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.POST,
                    "/api/preparedness/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/preparedness/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/preparedness/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/preparedness/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.POST,
                    "/api/emergencies/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/emergencies/**"
                ).authenticated()

                .requestMatchers(
                    HttpMethod.PUT,
                    "/api/emergencies/**"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.GET,
                    "/api/admin/dashboard"
                ).hasRole("ADMIN")

                .requestMatchers(
                    HttpMethod.DELETE,
                    "/api/emergencies/**"
                ).hasRole("ADMIN")

                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}