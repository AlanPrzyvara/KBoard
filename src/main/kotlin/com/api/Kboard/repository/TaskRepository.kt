package com.api.kboard.repository

import com.api.kboard.model.Task
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

// Anotação que marca esta interface como um componente de repositório do Spring
@Repository
// Interface que estende MongoRepository para operações CRUD básicas com a entidade Task
// O primeiro parâmetro (Task) é o tipo da entidade
// O segundo parâmetro (String) é o tipo do ID da entidade
interface TaskRepository : MongoRepository<Task, String> {
    // Método personalizado que busca todas as tarefas associadas a uma coluna específica
    // O Spring Data MongoDB implementará automaticamente este método baseado no nome
    fun findByColumnId(columnId: String): List<Task>
} 