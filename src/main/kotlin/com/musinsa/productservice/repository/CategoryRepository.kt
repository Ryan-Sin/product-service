package com.musinsa.productservice.repository

import com.musinsa.productservice.entity.CategoryEntity
import com.musinsa.productservice.entity.ProductEntity
import com.musinsa.productservice.persistence.CategoryPersistence
import com.musinsa.productservice.persistence.ProductPersistence
import org.springframework.stereotype.Repository

@Repository
class CategoryRepository(
    private val categoryPersistence: CategoryPersistence
) {
    fun findByName(name: String): CategoryEntity? {
        return this.categoryPersistence.findByName(name)
    }
}