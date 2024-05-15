package io.github.kirade.servlet.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseHtmlServlet", urlPatterns = ["/response-html"])
class ResponseHtmlServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        //Content-Type -> text/html;charset=utf-8
        response.contentType = "text/html"
        response.characterEncoding = "UTF-8"

        response.writer.println("<html>")
        response.writer.println("<body>")
        response.writer.println("안녕")
        response.writer.println("</body>")
        response.writer.println("</html>")
    }
}