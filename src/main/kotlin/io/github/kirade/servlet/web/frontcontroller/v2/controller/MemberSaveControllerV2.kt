package io.github.kirade.servlet.web.frontcontroller.v2.controller

import io.github.kirade.servlet.domain.member.Member
import io.github.kirade.servlet.domain.member.MemberRepository
import io.github.kirade.servlet.web.frontcontroller.MyView
import io.github.kirade.servlet.web.frontcontroller.v2.ControllerV2
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MemberSaveControllerV2: ControllerV2 {

    private val memberRepository = MemberRepository.getInstance()

    override fun process(request: HttpServletRequest, response: HttpServletResponse): MyView {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()
        val member = Member(username, age)
        memberRepository.save(member)

        // Model 에 데이터를 보관한다.
        request.setAttribute("member", member)

        return MyView("/WEB-INF/views/save-result.jsp")
    }
}