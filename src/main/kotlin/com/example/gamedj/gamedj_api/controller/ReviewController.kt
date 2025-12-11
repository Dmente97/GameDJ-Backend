package com.example.gamedj.gamedj_api.controller

import com.example.gamedj.gamedj_api.model.ReviewEntity
import com.example.gamedj.gamedj_api.repository.GameRepository
import com.example.gamedj.gamedj_api.repository.ReviewRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/games")
class ReviewController(
    private val gameRepository: GameRepository,
    private val reviewRepository: ReviewRepository
) {


    data class ReviewDto(
        val id: Long,
        val gameId: Long,
        val userId: Long,
        val stars: Double,
        val comment: String?,
        val createdAt: LocalDateTime?
    )

    data class CreateReviewRequest(
        val userId: Long,
        val stars: Double,
        val comment: String?
    )


    @GetMapping("/{gameId}/reviews")
    fun getReviewsForGame(@PathVariable gameId: Long): List<ReviewDto> {
        val reviews = reviewRepository.findByGameId(gameId)

        return reviews.map { r ->
            ReviewDto(
                id = r.id,
                gameId = r.gameId,
                userId = r.userId,
                stars = r.stars,
                comment = r.comment,
                createdAt = r.createdAt
            )
        }
    }


    @PostMapping("/{gameId}/reviews")
    fun createOrUpdateReviewForGame(
        @PathVariable gameId: Long,
        @RequestBody body: CreateReviewRequest
    ): ReviewDto {


        if (!gameRepository.existsById(gameId)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Juego no encontrado")
        }


        val existing = reviewRepository.findByGameIdAndUserId(gameId, body.userId)

        val toSave: ReviewEntity = if (existing != null) {
            existing.copy(
                stars = body.stars,
                comment = body.comment
            )
        } else {
            ReviewEntity(
                userId = body.userId,
                gameId = gameId,
                stars = body.stars,
                comment = body.comment
            )
        }

        val saved = reviewRepository.save(toSave)

        return ReviewDto(
            id = saved.id,
            gameId = saved.gameId,
            userId = saved.userId,
            stars = saved.stars,
            comment = saved.comment,
            createdAt = saved.createdAt
        )
    }

    // DELETE /api/games/{gameId}/reviews/{userId}
    @DeleteMapping("/{gameId}/reviews/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteReviewForGame(
        @PathVariable gameId: Long,
        @PathVariable userId: Long
    ) {
        val existing = reviewRepository.findByGameIdAndUserId(gameId, userId)
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Reseña no encontrada para este usuario y juego"
            )

        reviewRepository.delete(existing)
    }
}




