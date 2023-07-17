package com.project.demo.user

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.util.UUID

@Entity
@Table(name = "users")  // "user"은 postgresql의 예약어이기 때문에...
class User (

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    val name: String,

    @Positive(message = "0 이상이어야 합니다.")
    val age: Int,
) {
    @Id
    val id: UUID? = UUID.randomUUID()
}