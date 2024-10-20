package com.musinsa.productservice.controller

import com.musinsa.productservice.common.dto.SuccessResponseDto
import com.musinsa.productservice.controller.dto.*
import com.musinsa.productservice.controller.mapper.ProductMapper
import com.musinsa.productservice.service.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "상품 관련 API")
class ProductController(
    private val productMapper: ProductMapper,
    private val productService: ProductService
) {

    @PostMapping("")
    @Operation(
        summary = "상품 등록 API",
        description = "상품 정보를 입력해 상품을 등록합니다.",
    )
    fun registerProduct(dto: RegisterProductDto): SuccessResponseDto<Unit> {
        val command = this.productMapper.mapToRegisterProductCommand(dto)
        this.productService.registerProduct(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

    @PutMapping("")
    @Operation(
        summary = "상품 수정 API",
        description = "상품 정보를 입력해 상품을 수정합니다.",
    )
    fun updateProduct(dto: UpdateProductDto): SuccessResponseDto<Unit> {
        val command = this.productMapper.mapToUpdateProductCommand(dto)
        this.productService.updateProduct(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

    @DeleteMapping("")
    @Operation(
        summary = "특정 상품 삭제 API",
        description = "특정 상품을 삭제합니다.",
    )
    fun deleteProduct(@PathParam("id") id: Long): SuccessResponseDto<Unit> {
        val command = this.productMapper.mapToDeleteProductCommand(id)
        this.productService.deleteProduct(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

    @GetMapping("/categories/lowest-price")
    @Operation(
        summary = "카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API",
        description = "카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API",
        responses = [
            ApiResponse(
                responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = GetLowestPricedBrandByCategoryResponse::class)
                )]
            ),
        ]
    )
    fun getLowestPricedBrandByCategory(): SuccessResponseDto<GetLowestPricedBrandByCategoryResponse> {
        val info = this.productService.getLowestPricedBrandByCategory()
        val data = this.productMapper.mapToGetLowestPricedBrandByCategoryResponse(info)
        return SuccessResponseDto.setSuccess(data)
    }

    @GetMapping("/brands/total-price")
    @Operation(
        summary = "최저가격에 판매하는 브랜드와 카테고리의 상품가격 총액을 조회 API",
        description = "단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격 총액을 조회하는 API",
        responses = [
            ApiResponse(
                responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = GetTotalPriceForBrandAcrossCategoriesResponse::class)
                )]
            ),
        ]
    )
    fun getTotalPriceForBrandAcrossCategories(): SuccessResponseDto<GetTotalPriceForBrandAcrossCategoriesResponse> {
        val info = this.productService.getTotalPriceForBrandAcrossCategories()
        val data = this.productMapper.mapToGetTotalPriceForBrandAcrossCategoriesResponse(info)
        return SuccessResponseDto.setSuccess(data)
    }

    @GetMapping("/categories/price-range")
    @Operation(
        summary = "최고 가격 브랜드와 상품 가격을 조회하는 API",
        description = "카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API",
        responses = [
            ApiResponse(
                responseCode = "200", content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = GetPriceRangeForCategoryResponse::class)
                )]
            ),
        ]
    )
    fun getPriceRangeForCategory(dto: GetPriceRangeForCategoryDto): SuccessResponseDto<GetPriceRangeForCategoryResponse> {
        val command = this.productMapper.mapToGetPriceRangeForCategoryCommand(dto)
        val info = this.productService.getPriceRangeForCategory(command)
        val data = this.productMapper.mapToGetPriceRangeForCategoryResponse(info)
        return SuccessResponseDto.setSuccess(data)
    }
}