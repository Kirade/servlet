package io.github.kirade.servlet.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseHeaderServlet", value = ["/response-header"])
class ResponseHeaderServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        //{status-line}
        response.status = HttpServletResponse.SC_OK

        //{response-headers}
        //response.setHeader("Content-Type", "text/plain;charset=utf-8")
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        response.setHeader("Pragma", "no-cache")
        response.setHeader("my-header", "hello")

        response.contentType = "text/plain;charset=utf-8"

        //cookie
        val cookie = Cookie("myCookie", "good")
        cookie.maxAge = 600
        response.addCookie(cookie)

        //redirect
        //response.status = HttpServletResponse.SC_FOUND
        //response.setHeader("Location", "/basic/hello-form.html")

        response.sendRedirect("/basic/hello-form.html")


        response.writer.write("ok")
    }
}