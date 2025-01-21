package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    /*
    in here we use static to make it use for
    once and also you should know
    bcryptPasswordEncoder uses algorithm
    to hash the password
     */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) -> {
                            authorizeRequests.requestMatchers(
                                    "/api/swagger-ui/**",
                                    "/swagger-ui/**",
                                    "/api/v1/auth/**",
                                    "/v2/api-docs",
                                    "/v3/api-docs",
                                    "/v2/api-docs/**",
                                    "/v3/api-docs/**"
                                    ).permitAll();
                            authorizeRequests.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                            authorizeRequests.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
                            authorizeRequests.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
                            authorizeRequests.requestMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole("ADMIN", "USER");
                            authorizeRequests.requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER");
                            authorizeRequests.anyRequest().authenticated();
                        }
                ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Define a regular user with "USER" role
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")  // Assign "USER" role to this user
                .build();

        // Define an admin with "ADMIN" role
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")  // Assign "ADMIN" role to this user
                .build();

        // Return InMemoryUserDetailsManager with both users
        return new InMemoryUserDetailsManager(user, admin);
    }

}
