//package org.example.controller
package com.api.Kbank.controller

import com.api.Kbank.model.Account
import com.api.Kbank.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController (private val service: AccountService){
    @GetMapping
    fun indexAccount() = service.indexAccount()

    @GetMapping("/{id}")
    fun showAccount(@PathVariable id: String) =
        service.showAccount(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createAccount(@RequestBody account: Account) =
        ResponseEntity.ok(service.createAccount(account))

    @PutMapping("/{id}/balance")
    fun updateBalance(@PathVariable id: String, @RequestBody account: Account) =
        service.updateBalance(id, account.balance)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteAccount(@PathVariable id: String): ResponseEntity<Void> {
        service.deleteAccount(id)
        return ResponseEntity.noContent().build()
    }
}