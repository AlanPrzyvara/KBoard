package com.api.kboard.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// Anotação que indica que esta classe será armazenada como um documento no MongoDB
@Document(collection = "tasks")
data class Task(
    // Anotação que marca este campo como o identificador único do documento
    @Id
    val id: String? = null,    // ID opcional que será gerado automaticamente pelo MongoDB
    val title: String,         // Título da tarefa
    val description: String,   // Descrição detalhada da tarefa
    val columnId: String       // ID da coluna à qual esta tarefa pertence
) 