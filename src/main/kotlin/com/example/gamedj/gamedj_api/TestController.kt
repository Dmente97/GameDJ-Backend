package com.example.gamedj.gamedj_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/api/hello")
    fun hello(): String = "Backend GameDj OK"
}
