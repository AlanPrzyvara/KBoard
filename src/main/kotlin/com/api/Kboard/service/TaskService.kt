package com.api.kboard.service

import com.api.kboard.model.Task
import com.api.kboard.repository.TaskRepository
import org.springframework.stereotype.Service

// Anotação que marca esta classe como um componente de serviço do Spring
@Service
class TaskService(private val taskRepository: TaskRepository) {
    
    // Cria uma nova tarefa no banco de dados
    fun createTask(task: Task): Task {
        return taskRepository.save(task)
    }
    
    // Retorna todas as tarefas existentes
    fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }
    
    // Busca uma tarefa específica pelo ID
    fun getTaskById(id: String): Task? {
        return taskRepository.findById(id).orElse(null)
    }
    
    // Retorna todas as tarefas associadas a uma coluna específica
    fun getTasksByColumnId(columnId: String): List<Task> {
        return taskRepository.findByColumnId(columnId)
    }
    
    // Atualiza uma tarefa existente
    // Retorna null se a tarefa não existir
    fun updateTask(id: String, task: Task): Task? {
        return if (taskRepository.existsById(id)) {
            taskRepository.save(task.copy(id = id))
        } else null
    }
    
    // Move uma tarefa para uma nova coluna
    // Retorna null se a tarefa não existir
    fun moveTaskToColumn(taskId: String, newColumnId: String): Task? {
        val task = getTaskById(taskId) ?: return null
        return taskRepository.save(task.copy(columnId = newColumnId))
    }
    
    // Remove uma tarefa do banco de dados
    // Retorna true se a tarefa foi removida, false se não existia
    fun deleteTask(id: String): Boolean {
        return if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id)
            true
        } else false
    }
} 