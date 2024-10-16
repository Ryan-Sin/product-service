package com.musinsa.productservice.service.command

data class RegisterProductCommand(
    val productName: String,
    val brandName: String,
    val categoryName: String
)