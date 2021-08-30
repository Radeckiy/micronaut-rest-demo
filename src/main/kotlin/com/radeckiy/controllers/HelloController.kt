package com.radeckiy.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.slf4j.LoggerFactory

@Controller("/test")
class HelloController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    fun sayHello(): String {
        logger.info("fun sayHello() start")
        return "Hello!!!"
    }
}