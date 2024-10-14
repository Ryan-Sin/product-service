package com.musinsa.productservice.persistence

import com.musinsa.productservice.entity.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BrandPersistence : JpaRepository<BrandEntity, Long> {
    fun findByName(name: String): BrandEntity?
}