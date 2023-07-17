package com.project.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FrontController {

    @GetMapping("/enter")
    fun enter() = "Enter demo project"
}