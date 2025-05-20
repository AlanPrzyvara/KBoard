package com.api.kboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        
        // Permite requisições de qualquer origem
        config.addAllowedOrigin("*")
        
        // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc)
        config.addAllowedMethod("*")
        
        // Permite todos os headers
        config.addAllowedHeader("*")
        
        // Permite credenciais (cookies, headers de autenticação, etc)
        config.allowCredentials = true
        
        // Aplica a configuração para todos os endpoints da API
        source.registerCorsConfiguration("/api/**", config)
        
        return CorsFilter(source)
    }
} 