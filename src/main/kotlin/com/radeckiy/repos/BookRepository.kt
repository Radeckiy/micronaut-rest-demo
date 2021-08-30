package com.radeckiy.repos

import com.radeckiy.models.Book
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Slice
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository : CrudRepository<Book, Int> {
    fun list(pageable: Pageable): Slice<Book>
}