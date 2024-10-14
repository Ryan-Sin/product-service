package com.musinsa.productservice.service.command

data class RegisterCommand(val name: String)

data class UpdateBrandCommand(val id: Long, val name: String)

data class DeleteBrandCommand(val id: Long)