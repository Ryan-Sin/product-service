package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.CategoryEntity
import org.springframework.http.HttpStatus

fun validateCategoryExists(categoryEntity: CategoryEntity?) {
    if (categoryEntity != null) throw CommonException(HttpStatus.CONFLICT, ErrorMessage.EXIST_BRAND)
}

fun validateCategoryNotExists(categoryEntity: CategoryEntity?): CategoryEntity {
    return categoryEntity ?: throw CommonException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_EXIST_BRAND)
}