package com.example.Avocapplogin.config;

import com.example.Avocapplogin.config.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/register", "/auth/login").permitAll()
                        .requestMatchers("/api/ahkams/**").permitAll()
                        .requestMatchers("/personnes/**").permitAll()
                        .requestMatchers("/dossiers/**").permitAll()
                        .requestMatchers("/depenses/**").permitAll()
                        .requestMatchers("/assurances/**").permitAll()
                        .requestMatchers("/relations/**").permitAll()
                        .requestMatchers("/tanfids/**").permitAll()
                        .requestMatchers("/tablighs/**").permitAll()
                        .requestMatchers("/maktoubats/**").permitAll()
                        .requestMatchers("/jalassats/**").permitAll()
                        .requestMatchers("/charges/**").permitAll()
                        .requestMatchers("/procedures/**").permitAll()
                        .requestMatchers("/relations/assurancesdossiers/**").permitAll()
                        .requestMatchers("/relations/personnesdossiers/**").permitAll()



                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
