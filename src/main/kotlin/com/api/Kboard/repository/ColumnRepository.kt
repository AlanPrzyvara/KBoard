package com.api.kboard.repository

import com.api.kboard.model.Column
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

// Anotação que marca esta interface como um componente de repositório do Spring
@Repository
// Interface que estende MongoRepository para operações CRUD básicas com a entidade Column
// O primeiro parâmetro (Column) é o tipo da entidade
// O segundo parâmetro (String) é o tipo do ID da entidade
interface ColumnRepository : MongoRepository<Column, String> 