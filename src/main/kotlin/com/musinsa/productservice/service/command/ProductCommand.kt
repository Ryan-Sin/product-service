package com.musinsa.productservice.service.command

data class RegisterProductCommand(
    val productName: String,
    val price: Long,
    val brandName: String,
    val categoryName: String
)

data class UpdateProductCommand(
    val id: Long,
    val productName: String,
    val price: Long,
    val brandName: String,
    val categoryName: String
)

data class DeleteProductCommand(
    val id: Long
)