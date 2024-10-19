package com.musinsa.productservice.service

import com.musinsa.productservice.repository.ProductRepository
import com.musinsa.productservice.service.command.DeleteProductCommand
import com.musinsa.productservice.service.command.RegisterProductCommand
import com.musinsa.productservice.service.command.UpdateProductCommand
import com.musinsa.productservice.service.validator.validateProductExists
import com.musinsa.productservice.service.validator.validateProductNotExists
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val internalService: InternalService,
    private val productRepository: ProductRepository,
) {

    fun registerProduct(command: RegisterProductCommand) {
        val (productName, price, brandName, categoryName) = command

        val findProduct = this.productRepository.findByName(productName)
        validateProductExists(findProduct)

        val brand = this.internalService.getBrand(brandName)
        val category = this.internalService.getCategory(categoryName)

        this.productRepository.save(name = productName, price = price, brand = brand, category = category)
    }

    fun updateProduct(command: UpdateProductCommand) {
        val (id, productName, price, brandName, categoryName) = command

        val productEntityOptional = this.productRepository.findById(id)
        val productEntity = validateProductNotExists(productEntityOptional)

        val brand = this.internalService.getBrand(brandName)
        val category = this.internalService.getCategory(categoryName)

        productEntity.updateProductInfo(name = productName, price= price, brand = brand, category = category)

        this.productRepository.update(productEntity)
    }

    fun deleteProduct(command: DeleteProductCommand) {
        val id = command.id

        val productEntityOptional = this.productRepository.findById(id)
        val productEntity = validateProductNotExists(productEntityOptional)

        this.productRepository.softDelete(productEntity)
    }

}