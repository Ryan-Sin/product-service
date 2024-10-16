package com.musinsa.productservice.service

import com.musinsa.productservice.entity.BrandEntity
import com.musinsa.productservice.entity.CategoryEntity
import com.musinsa.productservice.repository.BrandRepository
import com.musinsa.productservice.repository.CategoryRepository
import com.musinsa.productservice.service.validator.validateBrandNotExists
import com.musinsa.productservice.service.validator.validateCategoryNotExists
import org.springframework.stereotype.Service

@Service
class InternalService(
    private val categoryRepository: CategoryRepository,
    private val brandRepository: BrandRepository
) {
    fun getCategory(name: String): CategoryEntity {
        val findCategory = this.categoryRepository.findByName(name)
        return validateCategoryNotExists(findCategory)
    }

    fun getBrand(name: String): BrandEntity {
        val findBrand = this.brandRepository.findByName(name)
        return validateBrandNotExists(findBrand)
    }
}