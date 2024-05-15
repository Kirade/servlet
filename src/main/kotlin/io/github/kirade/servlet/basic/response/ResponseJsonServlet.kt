package io.github.kirade.servlet.basic.response

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.kirade.servlet.basic.HelloData
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet: HttpServlet() {
    private val objectMapper = ObjectMapper()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "application/json"
        val helloData = HelloData()
        helloData.username = "kim"
        helloData.age = 20

        val result = objectMapper.writeValueAsString(helloData)

        response.writer.write(result)
    }
}