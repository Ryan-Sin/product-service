package com.musinsa.productservice.controller.mapper

import com.musinsa.productservice.controller.dto.RegisterDto
import com.musinsa.productservice.controller.dto.UpdateBrandDto
import com.musinsa.productservice.service.command.DeleteBrandCommand
import com.musinsa.productservice.service.command.RegisterCommand
import com.musinsa.productservice.service.command.UpdateBrandCommand
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface BrandMapper {
    fun mapToRegisterCommand(dto: RegisterDto): RegisterCommand
    fun mapToUpdateBrandCommand(dto: UpdateBrandDto): UpdateBrandCommand
    fun mapToDeleteBrandCommand(id: Long?): DeleteBrandCommand
}