package com.example.gamedj.gamedj_api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "reviews")
data class ReviewEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    val id: Long = 0,

    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(name = "game_id", nullable = false)
    val gameId: Long,

    @Column(name = "stars", nullable = false)
    val stars: Double,

    @Column(name = "comment")
    val comment: String? = null,

    @Column(name = "created_at", insertable = false, updatable = false)
    val createdAt: LocalDateTime? = null
)
