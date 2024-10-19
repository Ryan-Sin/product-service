package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.ProductEntity
import org.springframework.http.HttpStatus
import java.util.*

fun validateProductExists(productEntity: ProductEntity?) {
    if (productEntity != null) throw CommonException(HttpStatus.CONFLICT, ErrorMessage.EXIST_PRODUCT)
}

fun validateProductNotExists(productEntity: ProductEntity?): ProductEntity {
    return productEntity ?: throw CommonException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_EXIST_PRODUCT)
}

fun validateProductNotExists(productEntity: Optional<ProductEntity>): ProductEntity {
    return productEntity.orElseThrow{
        CommonException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_EXIST_PRODUCT)
    }
}