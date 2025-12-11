package com.example.gamedj.gamedj_api.repository

import com.example.gamedj.gamedj_api.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity?
}
