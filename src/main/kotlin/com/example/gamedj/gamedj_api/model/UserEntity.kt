package com.example.gamedj.gamedj_api.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0,

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = false, length = 150, unique = true)
    val email: String,

    @Column(nullable = false, length = 200)
    val password: String
)
