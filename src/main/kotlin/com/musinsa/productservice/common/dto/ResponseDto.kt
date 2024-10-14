package com.musinsa.productservice.common.dto

import java.time.Instant

data class ErrorResponseDto(
    val timeStamp: String = Instant.now().toString(),
    val message: Any?
)

