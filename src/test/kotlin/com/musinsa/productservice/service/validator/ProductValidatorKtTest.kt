package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.BrandEntity
import com.musinsa.productservice.entity.CategoryEntity
import com.musinsa.productservice.entity.ProductEntity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.test.Test

class ProductValidatorKtTest {

    @Test
    fun `상품가 존재 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val name = "A"
        val price = 3000L
        val brandEntity = BrandEntity(id = 1, name = "A")
        val categoryEntity = CategoryEntity(id = 1, name = "상의")
        val optionalProductEntity = Optional.of(
            ProductEntity(
                name = name,
                price = price,
                brand = brandEntity,
                category = categoryEntity
            )
        )

        // when(실행): 어떠한 함수를 실행하면
        val validateProductNotExists = validateProductNotExists(optionalProductEntity)

        // then(검증): 어떠한 결과가 나와야 한다.
        Assertions.assertThat(validateProductNotExists).isNotNull
    }

    @Test
    fun `상품이 존재하지 않음 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val productEntity: ProductEntity? = null
        val optionalProductEntity = Optional.ofNullable(productEntity)

        // when(실행): 어떠한 함수를 실행하면
        val exception = assertThrows<CommonException> {
            validateProductNotExists(optionalProductEntity)
        }

        // then(검증): 어떠한 결과가 나와야 한다.
        Assertions.assertThat(exception.status).isEqualTo(HttpStatus.NOT_FOUND)
        Assertions.assertThat(exception.clientErrorMessage).isEqualTo(ErrorMessage.NOT_EXIST_PRODUCT)
    }

    @Test
    fun `상품이 존재하면 Exception 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val name = "A"
        val price = 3000L
        val brandEntity = BrandEntity(id = 1, name = "A")
        val categoryEntity = CategoryEntity(id = 1, name = "상의")
        val productEntity = ProductEntity(
            name = name,
            price = price,
            brand = brandEntity,
            category = categoryEntity
        )

        // when(실행): 어떠한 함수를 실행하면
        val exception = assertThrows<CommonException> {
            validateProductExists(productEntity)
        }

        // then(검증): 어떠한 결과가 나와야 한다.
        Assertions.assertThat(exception.status).isEqualTo(HttpStatus.CONFLICT)
        Assertions.assertThat(exception.clientErrorMessage).isEqualTo(ErrorMessage.EXIST_PRODUCT)
    }
}
