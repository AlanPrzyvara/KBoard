package com.api.kboard.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// Anotação que indica que esta classe será armazenada como um documento no MongoDB
@Document(collection = "columns")
data class Column(
    // Anotação que marca este campo como o identificador único do documento
    @Id
    val id: String? = null, // ID opcional que será gerado automaticamente pelo MongoDB
    val name: String,       // Nome da coluna (ex: "To Do", "In Progress", "Done")
    val order: Int         // Número que define a ordem de exibição da coluna no quadro
) 