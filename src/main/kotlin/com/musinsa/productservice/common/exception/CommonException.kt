package com.musinsa.productservice.common.exception

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CommonException(
    val status: HttpStatus = HttpStatus.OK,
    val clientErrorMessage: String? = null,
    val serverErrorMessage: String? = null
) : RuntimeException()