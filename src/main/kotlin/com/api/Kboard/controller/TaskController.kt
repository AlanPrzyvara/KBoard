package com.api.kboard.controller

import com.api.kboard.model.Task
import com.api.kboard.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Anotação que marca esta classe como um controlador REST
@RestController
// Define o caminho base para todos os endpoints deste controlador
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {
    
    // Endpoint para criar uma nova tarefa
    // POST /api/tasks
    @PostMapping
    fun createTask(@RequestBody task: Task): ResponseEntity<Task> {
        return ResponseEntity.ok(taskService.createTask(task))
    }
    
    // Endpoint para listar todas as tarefas
    // GET /api/tasks
    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(taskService.getAllTasks())
    }
    
    // Endpoint para buscar uma tarefa específica pelo ID
    // GET /api/tasks/{id}
    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: String): ResponseEntity<Task> {
        return taskService.getTaskById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
    
    // Endpoint para listar todas as tarefas de uma coluna específica
    // GET /api/tasks/column/{columnId}
    @GetMapping("/column/{columnId}")
    fun getTasksByColumnId(@PathVariable columnId: String): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(taskService.getTasksByColumnId(columnId))
    }
    
    // Endpoint para atualizar uma tarefa existente
    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: Task): ResponseEntity<Task> {
        return taskService.updateTask(id, task)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
    
    // Endpoint para mover uma tarefa para outra coluna
    // PUT /api/tasks/{id}/move/{columnId}
    @PutMapping("/{id}/move/{columnId}")
    fun moveTaskToColumn(@PathVariable id: String, @PathVariable columnId: String): ResponseEntity<Task> {
        return taskService.moveTaskToColumn(id, columnId)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
    
    // Endpoint para remover uma tarefa
    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String): ResponseEntity<Unit> {
        return if (taskService.deleteTask(id)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
} 