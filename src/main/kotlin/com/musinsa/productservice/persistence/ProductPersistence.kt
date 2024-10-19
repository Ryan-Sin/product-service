package com.musinsa.productservice.persistence

import com.musinsa.productservice.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductPersistence: JpaRepository<ProductEntity, Long> {
    fun findByName(name: String): ProductEntity?

    @Query(""" select p from ProductEntity p join fetch p.category c join fetch p.brand b """)
    fun findJoinBrandAndCategory(): List<ProductEntity>

    @Query("""select p from ProductEntity p join fetch p.category c join fetch p.brand b where c.name = :categoryName""")
    fun findProductsByCategoryName(@Param("categoryName") categoryName: String): List<ProductEntity>
}