package com.musinsa.productservice.service.info

data class ProductMinPriceInfo(
    val categoryName: String,
    val brandName: String,
    val minPrice: Long,
)

data class GetLowestPricedBrandByCategoryInfo(
    val totalPrice: Long,
    val minPriceProducts: List<ProductMinPriceInfo>
)

data class CategoryPriceInfo(
    val 카테고리: String,
    val 가격: String
)

data class GetTotalPriceForBrandAcrossCategoriesInfo(
    val 브랜드: String,
    val 카테고리: List<CategoryPriceInfo>,
    val 총액: String
)

data class BrandPriceInfo(
    val 브랜드: String,
    val 가격: String
)

data class GetPriceRangeForCategoryInfo(
    val 카테고리: String,
    val 최저가: List<BrandPriceInfo>,
    val 최고가: List<BrandPriceInfo>
)