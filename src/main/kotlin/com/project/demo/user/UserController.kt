package com.project.demo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping()
    fun saveUser(@RequestBody request: UserSaveRequest): String{
        val user = User(request.name, request.age)
        val id = userService.saveUser(user)
        return "${user.name}이 저장되었습니다. ::::: $id"
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): UserResponse {
        val user = userService.findUser(id)
        return UserResponse(user.name, user.age)
    }

    @GetMapping()
    fun findAll(): List<UserResponse> {
        val users = userService.findAllUser()
        return users.map { user -> UserResponse(user.name, user.age) }.toList()
    }

}