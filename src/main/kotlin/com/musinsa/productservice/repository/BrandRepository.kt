package com.musinsa.productservice.repository

import com.musinsa.productservice.entity.BrandEntity
import com.musinsa.productservice.persistence.BrandPersistence
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BrandRepository(
    private val brandPersistence: BrandPersistence
) {
    fun save(name: String): BrandEntity {
        return this.brandPersistence.save(BrandEntity(name = name))
    }

    fun findByName(name: String): BrandEntity? {
        return this.brandPersistence.findByName(name)
    }

    fun update(brandEntity: BrandEntity): BrandEntity {
        return this.brandPersistence.save(brandEntity)
    }

    fun softDelete(brandEntity: BrandEntity) {
        this.brandPersistence.delete(brandEntity)
    }

    fun findById(id: Long): Optional<BrandEntity> {
        return this.brandPersistence.findById(id)
    }
}