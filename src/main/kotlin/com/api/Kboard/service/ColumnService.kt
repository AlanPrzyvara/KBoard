package com.api.kboard.service

import com.api.kboard.model.Column
import com.api.kboard.repository.ColumnRepository
import org.springframework.stereotype.Service

// Anotação que marca esta classe como um componente de serviço do Spring
@Service
class ColumnService(private val columnRepository: ColumnRepository) {
    
    // Cria uma nova coluna no banco de dados
    fun createColumn(column: Column): Column {
        return columnRepository.save(column)
    }
    
    // Retorna todas as colunas ordenadas por ordem
    fun getAllColumns(): List<Column> {
        return columnRepository.findAll().sortedBy { it.order }
    }
    
    // Busca uma coluna específica pelo ID
    fun getColumnById(id: String): Column? {
        return columnRepository.findById(id).orElse(null)
    }
    
    // Atualiza uma coluna existente
    // Retorna null se a coluna não existir
    fun updateColumn(id: String, column: Column): Column? {
        return if (columnRepository.existsById(id)) {
            columnRepository.save(column.copy(id = id))
        } else null
    }
    
    // Remove uma coluna do banco de dados
    // Retorna true se a coluna foi removida, false se não existia
    fun deleteColumn(id: String): Boolean {
        return if (columnRepository.existsById(id)) {
            columnRepository.deleteById(id)
            true
        } else false
    }
} 