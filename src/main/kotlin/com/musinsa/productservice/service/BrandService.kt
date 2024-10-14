package com.musinsa.productservice.service

import com.musinsa.productservice.repository.BrandRepository
import com.musinsa.productservice.service.command.DeleteBrandCommand
import com.musinsa.productservice.service.command.RegisterCommand
import com.musinsa.productservice.service.command.UpdateBrandCommand
import com.musinsa.productservice.service.validator.validateBrandExists
import com.musinsa.productservice.service.validator.validateBrandNotExists
import org.springframework.stereotype.Service

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {

    fun registerBrand(command: RegisterCommand) {
        val name = command.name

        val findBrand = this.brandRepository.findByName(name)
        validateBrandExists(findBrand)

        this.brandRepository.save(name = name)
    }

    fun updateBrand(command: UpdateBrandCommand) {
        val (id, name) = command

        val brandEntityOptional = this.brandRepository.findById(id)
        val brandEntity = validateBrandNotExists(brandEntityOptional)

        brandEntity.updateAll(name= name)
        this.brandRepository.update(brandEntity)
    }

    fun deleteBrand(command: DeleteBrandCommand) {
        val id = command.id

        val brandEntityOptional = this.brandRepository.findById(id)
        val brandEntity = validateBrandNotExists(brandEntityOptional)

        this.brandRepository.softDelete(brandEntity)
    }
}