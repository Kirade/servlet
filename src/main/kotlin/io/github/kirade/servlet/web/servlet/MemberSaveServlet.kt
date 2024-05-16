package io.github.kirade.servlet.web.servlet

import io.github.kirade.servlet.domain.member.Member
import io.github.kirade.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberSave", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {
    private val memberRepository = MemberRepository.getInstance()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("MemberSaveServlet.service")

        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        response.contentType = "text/html;charset=utf-8"
        val writer = response.writer
        writer.write(
            "<html>\n" +
                    "<head>\n" +
                    " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                    "<body>\n" +
                    "성공\n" +
                    "<ul>\n" +
                    "    <li>id=" + member.id + "</li>\n" +
                    "    <li>username=" + member.username + "</li>\n" +
                    " <li>age=" + member.age + "</li>\n" + "</ul>\n" +
                    "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                    "</html>"
        )
    }

}