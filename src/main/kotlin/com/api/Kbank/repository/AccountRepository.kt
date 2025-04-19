package com.api.Kbank.repository

import com.api.Kbank.model.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : MongoRepository<Account, String>{
}