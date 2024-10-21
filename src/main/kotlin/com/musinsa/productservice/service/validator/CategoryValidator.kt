package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.CategoryEntity
import org.springframework.http.HttpStatus

fun validateCategoryNotExists(categoryEntity: CategoryEntity?): CategoryEntity {
    return categoryEntity ?: throw CommonException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_EXIST_CATEGORY)
}