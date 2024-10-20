package com.musinsa.productservice.common.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema
import java.time.Instant

data class SuccessResponseDto<T>(
    @Schema(description = "응답 시간", example = "2024-06-27T03:17:05.114527Z")
    val timeStamp: String = Instant.now().toString(),

    @Schema(description = "응답 데이터")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: T? = null
) {
    companion object {
        fun <T> setDefaultSuccess(): SuccessResponseDto<T> {
            return SuccessResponseDto()
        }

        fun <T> setSuccess(data: T): SuccessResponseDto<T> {
            return SuccessResponseDto(data = data)
        }
    }
}

data class ErrorResponseDto(
    @Schema(description = "응답 시간", example = "2024-06-27T03:17:05.114527Z")
    val timeStamp: String = Instant.now().toString(),
    @Schema(description = "에러 메시지", example = "XXX 찾을 수 없습니다.")
    val message: Any?
)
