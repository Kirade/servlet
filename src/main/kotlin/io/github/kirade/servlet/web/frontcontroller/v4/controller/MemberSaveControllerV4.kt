package io.github.kirade.servlet.web.frontcontroller.v4.controller

import io.github.kirade.servlet.domain.member.Member
import io.github.kirade.servlet.domain.member.MemberRepository
import io.github.kirade.servlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4: ControllerV4 {
    private val memberRepository = MemberRepository.getInstance()

    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        val username = paramMap["username"].toString()
        val age = paramMap["age"]!!.toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        model["member"] = member
        return "save-result"
    }

}