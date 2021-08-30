package com.radeckiy.services

import com.radeckiy.models.Book
import io.micronaut.transaction.annotation.ReadOnly
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.transaction.Transactional
import javax.validation.constraints.NotNull

@Singleton
class BooksServices(private val entityManager: EntityManager) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @ReadOnly
    fun findById(@NotNull id: Int): Optional<Book> {
        logger.info("Выполнение операции findById(id = {})", id)

        val resultBook: Book = entityManager.find(Book::class.java, id)
        logger.info("Результат операции - {}", resultBook)

        return Optional.ofNullable(resultBook)
    }

    @Transactional
    fun save(book: Book): Book {
        logger.info("Выполнение операции save({})", book)
        entityManager.persist(book)

        return book
    }

    @ReadOnly
    fun findAll(): List<Book> {
        logger.info("Выполнение операции findAll()")
        val query: TypedQuery<Book> = entityManager.createQuery("SELECT b FROM Book as b order by b.name", Book::class.java)
        logger.info("Результат операции - {} объектов", query.resultList.size)

        return query.resultList
    }

    @Transactional
    fun deleteById(@NotNull id: Int): Unit {
        logger.info("Выполнение операции deleteById({})", id)
        findById(id).ifPresent(entityManager::remove)
    }
}