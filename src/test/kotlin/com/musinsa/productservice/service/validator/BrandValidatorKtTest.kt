package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.BrandEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus
import java.util.Optional
import kotlin.test.Test

class BrandValidatorKtTest {

    @Test
    fun `브랜드가 존재 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val name = "A"
        val optionalBrandEntity = Optional.of(BrandEntity(name = name))

        // when(실행): 어떠한 함수를 실행하면
        val validateBrandNotExists = validateBrandNotExists(optionalBrandEntity)

        // then(검증): 어떠한 결과가 나와야 한다.
        assertThat(validateBrandNotExists).isNotNull
    }

    @Test
    fun `브랜드가 존재하지 않음 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val brandEntity: BrandEntity? = null
        val optionalBrandEntity = Optional.ofNullable(brandEntity)

        // when(실행): 어떠한 함수를 실행하면
        val exception = assertThrows<CommonException> {
            validateBrandNotExists(optionalBrandEntity)
        }

        // then(검증): 어떠한 결과가 나와야 한다.
        assertThat(exception.status).isEqualTo(HttpStatus.NOT_FOUND)
        assertThat(exception.clientErrorMessage).isEqualTo(ErrorMessage.NOT_EXIST_BRAND)
    }

    @Test
    fun `브랜드가 존재하면 Exception 검증`() {
        val name = "A"
        val brandEntity = BrandEntity(name = name)

        // when(실행): 어떠한 함수를 실행하면
        val exception = assertThrows<CommonException> {
            validateBrandExists(brandEntity)
        }

        // then(검증): 어떠한 결과가 나와야 한다.
        assertThat(exception.status).isEqualTo(HttpStatus.CONFLICT)
        assertThat(exception.clientErrorMessage).isEqualTo(ErrorMessage.EXIST_BRAND)
    }
}