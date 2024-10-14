package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.BrandEntity
import org.springframework.http.HttpStatus
import java.util.*

fun validateBrandExists(brandEntity: BrandEntity?) {
    if(brandEntity != null) throw CommonException(HttpStatus.CONFLICT, ErrorMessage.EXIST_BRAND)
}

fun validateBrandNotExists(brandEntity: Optional<BrandEntity>): BrandEntity {
    return brandEntity.orElseThrow{
        CommonException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_EXIST_BRAND)
    }
}