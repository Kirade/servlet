package io.github.kirade.servlet.web.frontcontroller.v2.controller

import io.github.kirade.servlet.domain.member.MemberRepository
import io.github.kirade.servlet.web.frontcontroller.MyView
import io.github.kirade.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberListControllerV2: ControllerV2 {
    private val memberRepository = MemberRepository.getInstance()

    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val members = memberRepository.findAll()
        request.setAttribute("members", members)
        return MyView("/WEB-INF/views/members.jsp")
    }
}