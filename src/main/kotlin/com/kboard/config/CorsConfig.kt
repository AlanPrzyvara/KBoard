package com.kboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {

    @Bean
    fun corsFilter(): CorsFilter {
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOriginPattern("*") // Permite todas as origens em desenvolvimento
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        config.exposedHeaders = listOf("Access-Control-Allow-Origin")
        config.maxAge = 3600L // Cache das configurações CORS por 1 hora

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)

        return CorsFilter(source)
    }
} 