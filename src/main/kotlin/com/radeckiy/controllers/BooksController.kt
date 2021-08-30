package com.radeckiy.controllers

import com.radeckiy.repos.BookRepository
import com.radeckiy.models.Book
import io.micronaut.data.model.Pageable
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory

@Controller("/books")
class BooksController(private val bookRepository: BookRepository) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllBooks(): List<Book> {
        logger.info("fun getAllBooks() start")
        return bookRepository.findAll().toList()
    }

    @Get("/{pageNum}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPageBooks(@PathVariable pageNum: Int): List<Book> {
        logger.info("fun getAllBooks() start")
        return bookRepository.list(Pageable.from(pageNum, 10)).content
    }

    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun saveBook(book: Book): Book {
        return bookRepository.save(book)
    }
}