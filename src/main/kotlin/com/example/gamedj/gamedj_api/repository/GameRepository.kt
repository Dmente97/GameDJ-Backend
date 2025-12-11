package com.example.gamedj.gamedj_api.repository

import com.example.gamedj.gamedj_api.model.GameEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<GameEntity, Long>
