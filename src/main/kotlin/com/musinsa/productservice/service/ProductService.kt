package com.musinsa.productservice.service

import com.musinsa.productservice.repository.ProductRepository
import com.musinsa.productservice.service.command.RegisterProductCommand
import com.musinsa.productservice.service.validator.validateProductExists
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val internalService: InternalService,
    private val productRepository: ProductRepository,
) {

    fun registerProduct(command: RegisterProductCommand) {
        val (productName, brandName, categoryName) = command

        val findProduct = this.productRepository.findByName(productName)
        validateProductExists(findProduct)

        val brand = this.internalService.getBrand(brandName)
        val category = this.internalService.getCategory(categoryName)

        this.productRepository.save(name = productName, brand = brand, category = category)
    }

}