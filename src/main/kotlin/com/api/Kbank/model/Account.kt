package com.api.Kbank.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "accounts")
data class Account (
    @Id val id: String? = null,
    val name: String,
    val balance: Double

)