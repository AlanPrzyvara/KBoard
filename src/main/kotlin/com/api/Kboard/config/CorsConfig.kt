package com.api.kboard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("https://duration-international-excluding-genetics.trycloudflare.com", "https://simple-board-eta.vercel.app")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600)
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.allowCredentials = true
        config.addAllowedOrigin("https://duration-international-excluding-genetics.trycloudflare.com")
        config.addAllowedOrigin("https://simple-board-eta.vercel.app")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        config.maxAge = 3600L

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
