package com.api.Kbank.service

import com.api.Kbank.model.Account
import com.api.Kbank.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService (private val repository: AccountRepository){

    fun indexAccount(): List<Account> = repository.findAll()

    fun showAccount(id: String): Account? = repository.findById(id).orElse(null)

    fun createAccount(account: Account): Account = repository.save(account)

    fun updateBalance(id: String, newBalance: Double): Account? {
        val account = repository.findById(id).orElse(null)
        account?.let {
            val update = it.copy(balance = newBalance)
            return repository.save(update)
        }
        return null
    }

    fun deleteAccount(id: String) = repository.deleteById(id)
}