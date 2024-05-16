package io.github.kirade.servlet.web.frontcontroller.v3.controller

import io.github.kirade.servlet.domain.member.MemberRepository
import io.github.kirade.servlet.web.frontcontroller.ModelView
import io.github.kirade.servlet.web.frontcontroller.v3.ControllerV3

class MemberListControllerV3: ControllerV3 {
    private val memberRepository = MemberRepository.getInstance()

    override fun process(paramMap: Map<String, String>): ModelView {
        val members = memberRepository.findAll()

        val mv = ModelView("members")
        mv.model["members"] = members
        return mv
    }
}