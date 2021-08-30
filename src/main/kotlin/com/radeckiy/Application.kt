package com.radeckiy

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
        title = "micronaut-rest",
        version = "0.1"
    )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        build()
            .args(*args)
            .packages("com.radeckiy")
            .start()
    }
}

