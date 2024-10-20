package com.musinsa.productservice.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.media.MediaType
import io.swagger.v3.oas.models.media.Schema
import io.swagger.v3.oas.models.responses.ApiResponse
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Instant

@Configuration
class SwaggerConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .version("v1")
                    .title("카테고리 및 상품 관리 서비스")
                    .description("카테고리 및 상품 관리 API 서비스")
            )
    }

    @Bean
    fun customizeOperations(): OperationCustomizer {
        return OperationCustomizer { operation, handlerMethod ->
            operation.responses.forEach { (statusCode, response) ->
                if (statusCode == "200" || statusCode == "201") {
                    this.wrapperSuccessResponseBody(response)
                } else {
                    this.wrapperErrorResponseBody(response)
                }
            }

            operation
        }
    }

    private fun wrapperSuccessResponseBody(response: ApiResponse) {
        response.content?.forEach { mediaTypeKey: String?, mediaType: MediaType ->
            val wrapperSchema: Schema<*> = Schema<Any>()

            if(mediaType.schema.`$ref`.equals("#/components/schemas/SuccessResponseDtoUnit")) return@forEach

            wrapperSchema.addProperty(
                "timeStamp", Schema<Any>().type("string")
                    .title("응답 시간")
                    .format("date-time")
                    .example(Instant.now().toString())
            )
            wrapperSchema.addProperty("data", mediaType.schema)

            mediaType.schema = wrapperSchema
        }
    }

    private fun wrapperErrorResponseBody(response: ApiResponse) {
        response.content?.forEach { mediaTypeKey: String?, mediaType: MediaType ->
            val wrapperSchema: Schema<*> = Schema<Any>()
            wrapperSchema.addProperty(
                "timeStamp", Schema<Any>().type("string").format("date-time")
                    .title("응답 시간")
                    .example(Instant.now().toString())
            )
            wrapperSchema.addProperty(
                "message", Schema<Any>().type("string")
                    .title("에러 메시지")
                    .example(mediaType.schema.default)
            )

            mediaType.schema = wrapperSchema
        }
    }
}