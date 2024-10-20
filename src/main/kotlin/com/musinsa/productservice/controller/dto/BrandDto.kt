package com.musinsa.productservice.controller.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class RegisterDto(
    @field:NotBlank(message = "브랜드 이름을 입력해 주세요.")
    @Schema(description = "브랜드의 이름", example = "나이키")
    val name: String
)

data class UpdateBrandDto(
    @field:NotNull(message = "브랜드 ID를 입력해 주세요.")
    @Schema(description = "브랜드의 ID", example = "1")
    val id: Long,

    @field:NotBlank(message = "브랜드 이름을 입력해 주세요.")
    @Schema(description = "브랜드의 이름", example = "아디다스")
    val name: String
)
