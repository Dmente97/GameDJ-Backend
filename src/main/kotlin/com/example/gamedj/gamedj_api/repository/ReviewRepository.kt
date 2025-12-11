package com.example.gamedj.gamedj_api.repository

import com.example.gamedj.gamedj_api.model.ReviewEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<ReviewEntity, Long> {

    fun findByGameId(gameId: Long): List<ReviewEntity>


    fun findByGameIdAndUserId(gameId: Long, userId: Long): ReviewEntity?
}

