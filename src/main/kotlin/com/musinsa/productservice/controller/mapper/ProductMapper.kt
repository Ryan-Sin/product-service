package com.musinsa.productservice.controller.mapper

import com.musinsa.productservice.controller.dto.*
import com.musinsa.productservice.service.command.DeleteProductCommand
import com.musinsa.productservice.service.command.GetPriceRangeForCategoryCommand
import com.musinsa.productservice.service.command.RegisterProductCommand
import com.musinsa.productservice.service.command.UpdateProductCommand
import com.musinsa.productservice.service.info.GetLowestPricedBrandByCategoryInfo
import com.musinsa.productservice.service.info.GetPriceRangeForCategoryInfo
import com.musinsa.productservice.service.info.GetTotalPriceForBrandAcrossCategoriesInfo
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface ProductMapper {
    fun mapToRegisterProductCommand(dto: RegisterProductDto): RegisterProductCommand
    fun mapToUpdateProductCommand(dto: UpdateProductDto): UpdateProductCommand
    fun mapToDeleteProductCommand(id: Long?): DeleteProductCommand
    fun mapToGetLowestPricedBrandByCategoryResponse(info: GetLowestPricedBrandByCategoryInfo): GetLowestPricedBrandByCategoryResponse
    fun mapToGetTotalPriceForBrandAcrossCategoriesResponse(info: GetTotalPriceForBrandAcrossCategoriesInfo): GetTotalPriceForBrandAcrossCategoriesResponse
    fun mapToGetPriceRangeForCategoryResponse(info: GetPriceRangeForCategoryInfo): GetPriceRangeForCategoryResponse
    fun mapToGetPriceRangeForCategoryCommand(dto: GetPriceRangeForCategoryDto): GetPriceRangeForCategoryCommand

}