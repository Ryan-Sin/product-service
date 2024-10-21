package com.musinsa.productservice.service.validator

import com.musinsa.productservice.common.exception.CommonException
import com.musinsa.productservice.common.exception.ErrorMessage
import com.musinsa.productservice.entity.CategoryEntity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.springframework.http.HttpStatus
import kotlin.test.Test

class CategoryValidatorKtTest {
    @Test
    fun `카테고리가 존재하지 않음 검증`() {
        // given(준비): 어떠한 데이터가 준비되었을 때
        val categoryEntity: CategoryEntity? = null

        // when(실행): 어떠한 함수를 실행하면
        val exception = assertThrows<CommonException> {
            validateCategoryNotExists(categoryEntity)
        }

        // then(검증): 어떠한 결과가 나와야 한다.
        Assertions.assertThat(exception.status).isEqualTo(HttpStatus.NOT_FOUND)
        Assertions.assertThat(exception.clientErrorMessage).isEqualTo(ErrorMessage.NOT_EXIST_CATEGORY)
    }
}