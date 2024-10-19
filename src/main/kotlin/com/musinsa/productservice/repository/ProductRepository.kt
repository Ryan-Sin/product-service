package com.musinsa.productservice.repository

import com.musinsa.productservice.entity.BrandEntity
import com.musinsa.productservice.entity.CategoryEntity
import com.musinsa.productservice.entity.ProductEntity
import com.musinsa.productservice.persistence.ProductPersistence
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductRepository(
    private val productPersistence: ProductPersistence
) {
    fun save(name: String, price: Long, brand: BrandEntity, category: CategoryEntity): ProductEntity {
        return this.productPersistence.save(
            ProductEntity(
                name = name,
                price = price,
                brand = brand,
                category = category
            )
        )
    }

    fun findByName(name: String): ProductEntity? {
       return this.productPersistence.findByName(name)
    }

    fun update(product: ProductEntity): ProductEntity {
        return this.productPersistence.save(product)
    }

    fun findById(id: Long): Optional<ProductEntity> {
        return this.productPersistence.findById(id)
    }

    fun softDelete(productEntity: ProductEntity) {
        this.productPersistence.delete(productEntity)
    }
}