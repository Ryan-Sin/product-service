package com.musinsa.productservice.persistence

import com.musinsa.productservice.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryPersistence: JpaRepository<CategoryEntity, Long>