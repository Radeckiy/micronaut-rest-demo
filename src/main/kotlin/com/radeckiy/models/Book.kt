package com.radeckiy.models

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val isbn: String,
    @Column(nullable = false)
    val language: String,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    val author: BookAuthor,
    @Column(name = "publication_year")
    val publicationYear: Int
)
