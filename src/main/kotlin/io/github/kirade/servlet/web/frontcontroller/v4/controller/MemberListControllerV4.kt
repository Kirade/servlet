package io.github.kirade.servlet.web.frontcontroller.v4.controller

import io.github.kirade.servlet.domain.member.MemberRepository
import io.github.kirade.servlet.web.frontcontroller.ModelView
import io.github.kirade.servlet.web.frontcontroller.v3.ControllerV3
import io.github.kirade.servlet.web.frontcontroller.v4.ControllerV4

class MemberListControllerV4: ControllerV4 {
    private val memberRepository = MemberRepository.getInstance()

    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        val members = memberRepository.findAll()

        model["members"] = members
        return "members"
    }

}