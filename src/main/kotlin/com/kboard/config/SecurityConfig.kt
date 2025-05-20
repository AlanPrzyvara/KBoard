package com.kboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { cors ->
                cors.configurationSource { request ->
                    val config = org.springframework.web.cors.CorsConfiguration()
                    config.addAllowedOrigin("http://localhost:3000")
                    config.addAllowedMethod("*")
                    config.addAllowedHeader("*")
                    config.allowCredentials = true
                    config
                }
            }
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(AntPathRequestMatcher("/**")).permitAll()
            }
            .headers { headers ->
                headers.frameOptions { it.disable() }
            }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }

        return http.build()
    }
} 