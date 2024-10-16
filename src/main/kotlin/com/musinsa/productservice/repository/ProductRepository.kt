package com.musinsa.productservice.repository

import com.musinsa.productservice.entity.BrandEntity
import com.musinsa.productservice.entity.CategoryEntity
import com.musinsa.productservice.entity.ProductEntity
import com.musinsa.productservice.persistence.ProductPersistence
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
    private val productPersistence: ProductPersistence
) {
    fun save(name: String, brand: BrandEntity, category: CategoryEntity): ProductEntity {
        return this.productPersistence.save(
            ProductEntity(
                name = name,
                brand = brand,
                category = category
            )
        )
    }

    fun findByName(name: String): ProductEntity? {
       return this.productPersistence.findByName(name)
    }
}