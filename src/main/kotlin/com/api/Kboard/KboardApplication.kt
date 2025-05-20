package com.api.kboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// Anotação que marca esta classe como uma aplicação Spring Boot
@SpringBootApplication
class KboardApplication

// Função principal que inicia a aplicação
fun main(args: Array<String>) {
    runApplication<KboardApplication>(*args)
} 