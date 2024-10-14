package com.musinsa.productservice.persistence

import com.musinsa.productservice.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductPersistence: JpaRepository<ProductEntity, Long>