package com.project.demo.user

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun saveUser(user: User): UUID {
        val saved = userRepository.save(user)
        return saved.id ?: throw IllegalStateException("유저가 저장되지 않았습니다.")
    }

    fun findUser(id: UUID) = userRepository.findById(id) ?: throw IllegalStateException("유저가 존재하지 않습니다. ::: $id")
    fun findAllUser() = userRepository.findAll()

}