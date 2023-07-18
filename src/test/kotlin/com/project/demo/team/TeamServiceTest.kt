package com.project.demo.team

import com.project.demo.user.User
import com.project.demo.user.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class TeamServiceTest {

    @Autowired
    lateinit var teamService: TeamService

    @Autowired
    lateinit var userService: UserService
    @Test
    fun `팀을 하나 생성하고 유저 둘을 넣는다` () {
        val team = Team("팀1")
        teamService.makeTeam(team)

        val user1 = User("유저1", 30)
        val user2 = User("유저2", 60)
        userService.saveUser(user1)
        userService.saveUser(user2)

        user1.joinTeam(team)
        user2.joinTeam(team)

        assertThat(team.users.size).isEqualTo(2)
    }
}