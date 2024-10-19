package com.musinsa.productservice.service

import com.musinsa.productservice.repository.ProductRepository
import com.musinsa.productservice.service.command.DeleteProductCommand
import com.musinsa.productservice.service.command.GetPriceRangeForCategoryCommand
import com.musinsa.productservice.service.command.RegisterProductCommand
import com.musinsa.productservice.service.command.UpdateProductCommand
import com.musinsa.productservice.service.info.*
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

        productEntity.updateProductInfo(name = productName, price = price, brand = brand, category = category)

        this.productRepository.update(productEntity)
    }

    fun deleteProduct(command: DeleteProductCommand) {
        val id = command.id

        val productEntityOptional = this.productRepository.findById(id)
        val productEntity = validateProductNotExists(productEntityOptional)

        this.productRepository.softDelete(productEntity)
    }

    fun getLowestPricedBrandByCategory(): GetLowestPricedBrandByCategoryInfo {
        val productEntities = this.productRepository.findJoinBrandAndCategory()

        val minPriceProducts = productEntities.groupBy { it.getCategory().name }
            .asSequence()
            .map { entry ->
                val products = entry.value
                val product = products.minBy { it.getPrice() }
                ProductMinPriceInfo(
                    categoryName = entry.key,
                    brandName = product.getBrand().getName(),
                    minPrice = product.getPrice()
                )
            }.toList()

        val totalPrice = minPriceProducts.sumOf { it.minPrice }

        return GetLowestPricedBrandByCategoryInfo(
            totalPrice = totalPrice,
            minPriceProducts = minPriceProducts
        )
    }

    fun getTotalPriceForBrandAcrossCategories(): GetTotalPriceForBrandAcrossCategoriesInfo {
        val productEntities = this.productRepository.findJoinBrandAndCategory()

        val brandCategoryPricesWithTotal = productEntities.groupBy { it.getBrand().getName() }
            .asSequence()
            .map { (brand, products) ->
                val categories = products
                    .asSequence()
                    .map {
                        CategoryPriceInfo(
                            카테고리 = it.getCategory().name,
                            가격 = it.getPrice().toString()
                        )
                    }.toList()

                val totalAmount = products.sumOf { it.getPrice() }
                brand to (categories to totalAmount)
            }.toMap()

        val lowestBrandEntry = brandCategoryPricesWithTotal.minByOrNull { it.value.second }!!

        val categories = lowestBrandEntry.value.first.map {
            it.copy(가격 = String.format("%,d", it.가격.toLong()))
        }

        val totalAmount = String.format("%,d", lowestBrandEntry.value.second)

        return GetTotalPriceForBrandAcrossCategoriesInfo(
            브랜드 = lowestBrandEntry.key,
            카테고리 = categories,
            총액 = totalAmount
        )
    }

    fun getPriceRangeForCategory(command: GetPriceRangeForCategoryCommand): GetPriceRangeForCategoryInfo {
        val categoryName = command.categoryName
        val productEntities = this.productRepository.findProductsByCategoryName(categoryName)

        val lowestPriceProduct = productEntities.minBy { it.getPrice() }
        val highestPriceProduct = productEntities.maxBy { it.getPrice() }

        val lowestPriceInfo = BrandPriceInfo(
            브랜드 = lowestPriceProduct.getBrand().getName(),
            가격 = String.format("%,d", lowestPriceProduct.getPrice())
        )

        val highestPriceInfo = BrandPriceInfo(
            브랜드 = highestPriceProduct.getBrand().getName(),
            가격 = String.format("%,d", highestPriceProduct.getPrice())
        )

        return GetPriceRangeForCategoryInfo(
            카테고리 = categoryName,
            최저가 = listOf(lowestPriceInfo),
            최고가 = listOf(highestPriceInfo)
        )
    }
}