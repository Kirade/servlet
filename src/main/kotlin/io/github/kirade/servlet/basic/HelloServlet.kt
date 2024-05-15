package io.github.kirade.servlet.basic

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "Hello", urlPatterns = ["/hello"])
class HelloServlet: HttpServlet() {

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("HelloServlet.service")
        println(request)
        println(response)

        val username = request.getParameter("username")
        println(username)

        response.contentType = "text/plain"
        response.characterEncoding = "utf-8"
        response.writer.write("hello $username")
    }
}