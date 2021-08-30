package com.radeckiy.models

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "book_authors")
data class BookAuthor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(nullable = false)
    val fio: String,
    @Column(nullable = false)
    val birthday: Date
)