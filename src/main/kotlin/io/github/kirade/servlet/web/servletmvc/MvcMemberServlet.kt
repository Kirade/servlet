package io.github.kirade.servlet.web.servletmvc

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberServlet", urlPatterns = ["/servlet-mvc/members/new-form"])
class MvcMemberServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val viewPath = "/WEB-INF/views/new-form.jsp"
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }
}