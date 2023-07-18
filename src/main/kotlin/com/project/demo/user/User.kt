package com.project.demo.user

import com.project.demo.team.Team
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

@Entity
@Table(name = "users")  // "user"은 postgresql의 예약어이기 때문에...
class User(

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    val name: String,

    @Positive(message = "0 이상이어야 합니다.")
    val age: Int,

) {

    @JoinColumn(name = "team_id")
    @ManyToOne(fetch = FetchType.LAZY)
    var team: Team? = null

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    /**
     * 유저가 팀에 가입하는 메소드
     */
    fun joinTeam(team: Team) {
        this.team = team
        team.users.plus(this)
    }
}