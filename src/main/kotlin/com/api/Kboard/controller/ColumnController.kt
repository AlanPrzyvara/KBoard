package com.api.kboard.controller

import com.api.kboard.model.Column
import com.api.kboard.service.ColumnService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Anotação que marca esta classe como um controlador REST
@RestController
// Define o caminho base para todos os endpoints deste controlador
@RequestMapping("/api/columns")
class ColumnController(private val columnService: ColumnService) {
    
    // Endpoint para criar uma nova coluna
    // POST /api/columns
    @PostMapping
    fun createColumn(@RequestBody column: Column): ResponseEntity<Column> {
        return ResponseEntity.ok(columnService.createColumn(column))
    }
    
    // Endpoint para listar todas as colunas
    // GET /api/columns
    @GetMapping
    fun getAllColumns(): ResponseEntity<List<Column>> {
        return ResponseEntity.ok(columnService.getAllColumns())
    }
    
    // Endpoint para buscar uma coluna específica pelo ID
    // GET /api/columns/{id}
    @GetMapping("/{id}")
    fun getColumnById(@PathVariable id: String): ResponseEntity<Column> {
        return columnService.getColumnById(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
    
    // Endpoint para atualizar uma coluna existente
    // PUT /api/columns/{id}
    @PutMapping("/{id}")
    fun updateColumn(@PathVariable id: String, @RequestBody column: Column): ResponseEntity<Column> {
        return columnService.updateColumn(id, column)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }
    
    // Endpoint para remover uma coluna
    // DELETE /api/columns/{id}
    @DeleteMapping("/{id}")
    fun deleteColumn(@PathVariable id: String): ResponseEntity<Unit> {
        return if (columnService.deleteColumn(id)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
} 