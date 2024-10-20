package com.musinsa.productservice.repository

import com.musinsa.productservice.persistence.ProductPersistence
import com.musinsa.productservice.service.info.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private lateinit var productPersistence: ProductPersistence

    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setUp() {
        this.productRepository = ProductRepository(this.productPersistence)
    }

    @Test
    fun `데이터 조회 테스트`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val categoryName = "상의"
        val productEntities = this.productRepository.findProductsByCategoryName(categoryName)

        // 상품이 없을 경우 처리
        if (productEntities.isEmpty()) {
            throw IllegalArgumentException("해당 카테고리의 상품이 없습니다.")
        }

        // 최저가 상품 찾기
        val lowestPriceProduct = productEntities.minByOrNull { it.getPrice() }
            ?: throw IllegalArgumentException("최저가 상품을 찾을 수 없습니다.")

        // 최고가 상품 찾기
        val highestPriceProduct = productEntities.maxByOrNull { it.getPrice() }
            ?: throw IllegalArgumentException("최고가 상품을 찾을 수 없습니다.")

        // 최저가와 최고가 브랜드 정보 및 가격 구성
        val lowestPriceInfo = BrandPriceInfo(
            브랜드 = lowestPriceProduct.getBrand().getName(),
            가격 = String.format("%,d", lowestPriceProduct.getPrice())
        )

        val highestPriceInfo = BrandPriceInfo(
            브랜드 = highestPriceProduct.getBrand().getName(),
            가격 = String.format("%,d", highestPriceProduct.getPrice())
        )

        println(listOf(lowestPriceInfo))
        println(listOf(highestPriceInfo))

        // then(검증): 어떠한 결과가 나와야 한다.
    }

}