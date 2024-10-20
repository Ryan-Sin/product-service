package com.musinsa.productservice.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class RegisterProductDto(
    @field:NotBlank(message = "상품 이름을 입력해 주세요.")
    @Schema(description = "상품 이름", example = "티셔츠")
    val productName: String,

    @field:NotNull(message = "가격을 입력해 주세요.")
    @field:Min(value = 0, message = "가격은 0 이상이어야 합니다.")
    @Schema(description = "상품 가격", example = "10000")
    val price: Long,

    @field:NotBlank(message = "브랜드 이름을 입력해 주세요.")
    @Schema(description = "브랜드 이름", example = "나이키")
    val brandName: String,

    @field:NotBlank(message = "카테고리 이름을 입력해 주세요.")
    @Schema(description = "카테고리 이름", example = "의류")
    val categoryName: String
)

data class UpdateProductDto(
    @field:NotNull(message = "상품 ID를 입력해 주세요.")
    @Schema(description = "상품 ID", example = "1")
    val id: Long,

    @field:NotBlank(message = "상품 이름을 입력해 주세요.")
    @Schema(description = "상품 이름", example = "티셔츠")
    val productName: String,

    @field:NotNull(message = "가격을 입력해 주세요.")
    @field:Min(value = 0, message = "가격은 0 이상이어야 합니다.")
    @Schema(description = "상품 가격", example = "10000")
    val price: Long,

    @field:NotBlank(message = "브랜드 이름을 입력해 주세요.")
    @Schema(description = "브랜드 이름", example = "나이키")
    val brandName: String,

    @field:NotBlank(message = "카테고리 이름을 입력해 주세요.")
    @Schema(description = "카테고리 이름", example = "의류")
    val categoryName: String
)

data class ProductMinPrice(
    @Schema(description = "카테고리 이름", example = "상의")
    val categoryName: String,

    @Schema(description = "브랜드 이름", example = "C")
    val brandName: String,

    @Schema(description = "최소 가격", example = "10000")
    val minPrice: Long,
)

data class GetLowestPricedBrandByCategoryResponse(
    @Schema(description = "총액", example = "34100")
    val totalPrice: Long,

    @Schema(description = "최저 가격 제품 리스트")
    val minPriceProducts: List<ProductMinPrice>
)

data class CategoryPrice(
    @Schema(description = "카테고리 이름", example = "상의")
    @JsonProperty("카테고리")
    val 카테고리: String,

    @Schema(description = "가격", example = "10000")
    @JsonProperty("가격")
    val 가격: String
)

data class GetTotalPriceForBrandAcrossCategoriesResponse(
    @Schema(description = "브랜드 이름", example = "D")
    @JsonProperty("브랜드")
    val 브랜드: String,

    @Schema(description = "카테고리별 가격 리스트")
    @JsonProperty("카테고리")
    val 카테고리: List<CategoryPrice>,

    @Schema(description = "총액", example = "36100")
    @JsonProperty("총액")
    val 총액: String
)

data class GetPriceRangeForCategoryDto(
    @field:NotBlank(message = "카테고리 이름을 입력해 주세요.")
    @Schema(description = "카테고리 이름", example = "상의")
    val categoryName: String
)

data class BrandPrice(
    @Schema(description = "브랜드 이름", example = "C")
    @JsonProperty("브랜드")
    val 브랜드: String,

    @Schema(description = "가격", example = "10000")
    @JsonProperty("가격")
    val 가격: String
)

data class GetPriceRangeForCategoryResponse(
    @Schema(description = "카테고리 이름", example = "상의")
    @JsonProperty("카테고리")
    val 카테고리: String,

    @Schema(description = "최저 가격 브랜드 리스트")
    @JsonProperty("최저가")
    val 최저가: List<BrandPrice>,

    @Schema(description = "최고 가격 브랜드 리스트")
    @JsonProperty("최고가")
    val 최고가: List<BrandPrice>
)
