package com.example.gamedj.gamedj_api.model

import jakarta.persistence.*

@Entity
@Table(name = "games")
data class GameEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    val id: Long = 0,

    @Column(nullable = false, length = 150)
    val title: String,

    @Column(nullable = false, length = 100)
    val platform: String,

    @Column(name = "release_year", nullable = false)
    val releaseYear: Int,


    @Column(name = "image_name", length = 100)
    val imageName: String? = null
)
