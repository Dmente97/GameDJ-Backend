package com.example.gamedj.gamedj_api.controller

import com.example.gamedj.gamedj_api.model.GameEntity
import com.example.gamedj.gamedj_api.model.ReviewEntity
import com.example.gamedj.gamedj_api.repository.GameRepository
import com.example.gamedj.gamedj_api.repository.ReviewRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Locale

@RestController
@RequestMapping("/api/games")
class GameController(
    private val gameRepository: GameRepository,
    private val reviewRepository: ReviewRepository
) {

    data class GameDto(
        val id: Long,
        val title: String,
        val platform: String,
        val releaseYear: Int,
        val imageName: String?,
        val averageStars: Double?,
        val reviewCount: Int
    )

    @GetMapping
    fun getAllGames(): List<GameDto> {
        val games: List<GameEntity> = gameRepository.findAll()

        return games.map { game ->
            val reviews: List<ReviewEntity> = reviewRepository.findByGameId(game.id)

            val avg: Double? = if (reviews.isNotEmpty()) {
                reviews.map { it.stars }.average()
            } else null

            val safeAverage = avg?.let {
                String.format(Locale.US, "%.1f", it).toDouble()
            }

            GameDto(
                id = game.id,
                title = game.title,
                platform = game.platform,
                releaseYear = game.releaseYear,
                imageName = game.imageName,
                averageStars = safeAverage,
                reviewCount = reviews.size
            )
        }
    }
}

