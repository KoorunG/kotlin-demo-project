package com.project.demo.user

import org.springframework.data.repository.Repository
import java.util.*

interface UserRepository: Repository<User, Long> {

    fun save(user: User): User  // User를 저장하고 식별자를 리턴
    fun findById(id: Long): User? // 코틀린에서는 Optional 대신 Nullable 타입을 사용한다.
    fun findAll(): List<User>   // 모든 유저 검색
}