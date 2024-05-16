package io.github.kirade.servlet.domain.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemberRepositoryTest {
    private val memberRepository = MemberRepository.getInstance()

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun save(){
        val member = Member(username="hello", age=20)
        val savedMember = memberRepository.save(member)

        val findMember = memberRepository.findById(savedMember.id!!)
        assertThat(findMember).isEqualTo(savedMember)
    }

    @Test
    fun findAll() {
        val member1 = Member(username="hello", age=20)
        val member2 = Member(username="hello", age=30)

        memberRepository.save(member1)
        memberRepository.save(member2)

        val result= memberRepository.findAll()

        assertThat(result.size).isEqualTo(2)
        assertThat(result).contains(member1, member2)
    }
}