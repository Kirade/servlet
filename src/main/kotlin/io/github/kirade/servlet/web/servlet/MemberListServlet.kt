package io.github.kirade.servlet.web.servlet

import io.github.kirade.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet : HttpServlet() {

    val memberRepository: MemberRepository = MemberRepository.getInstance()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val members = memberRepository.findAll()

        response.contentType = "text/html;charset=UTF-8"

        val w = response.writer

        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("    <thead>");
        w.write("    <th>id</th>");
        w.write("    <th>username</th>");
        w.write("    <th>age</th>");
        w.write("    </thead>");
        w.write("    <tbody>");

        for (member in members) {
            w.write("    <tr>");
            w.write("        <td>"+member.id+"</td>");
            w.write("        <td>"+member.username+"</td>");
            w.write("        <td>"+member.age+"</td>");
            w.write("    </tr>");
        }

        w.write("    </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}