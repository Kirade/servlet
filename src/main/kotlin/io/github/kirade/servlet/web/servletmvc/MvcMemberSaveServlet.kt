package io.github.kirade.servlet.web.servletmvc

import io.github.kirade.servlet.domain.member.Member
import io.github.kirade.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet: HttpServlet() {

    private val memberRepository = MemberRepository.getInstance()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        // Model 에 데이터를 보관한다.
        request.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}