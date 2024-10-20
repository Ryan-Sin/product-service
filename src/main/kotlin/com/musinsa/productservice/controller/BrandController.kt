package com.musinsa.productservice.controller

import com.musinsa.productservice.common.dto.SuccessResponseDto
import com.musinsa.productservice.controller.dto.RegisterDto
import com.musinsa.productservice.controller.dto.UpdateBrandDto
import com.musinsa.productservice.controller.mapper.BrandMapper
import com.musinsa.productservice.service.BrandService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/brand")
@Tag(name = "Brand", description = "브랜드 관련 API")
class BrandController(
    private val brandMapper: BrandMapper,
    private val brandService: BrandService
) {
    @PostMapping("")
    @Operation(
        summary = "브랜드 등록 API",
        description = "브랜드 정보를 입력해 브랜드를 등록합니다.",
    )
    fun registerBrand(@RequestBody @Valid dto: RegisterDto): SuccessResponseDto<Unit> {
        val command = this.brandMapper.mapToRegisterCommand(dto)
        this.brandService.registerBrand(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

    @PutMapping("")
    @Operation(
        summary = "브랜드 수정 API",
        description = "브랜드 정보를 입력해 브랜드를 수정합니다.",
    )
    fun updateBrand(@RequestBody @Valid dto: UpdateBrandDto): SuccessResponseDto<Unit> {
        val command = this.brandMapper.mapToUpdateBrandCommand(dto)
        this.brandService.updateBrand(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "특정 브랜드 삭제 API",
        description = "특정 브랜드 삭제합니다.",
    )
    fun deleteBrand(@PathVariable id: Long): SuccessResponseDto<Unit> {
        val command = this.brandMapper.mapToDeleteBrandCommand(id)
        this.brandService.deleteBrand(command)
        return SuccessResponseDto.setDefaultSuccess()
    }

}