package io.github.kirade.servlet.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.kirade.servlet.basic.HelloData
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet: HttpServlet() {

    private val objectMapper = ObjectMapper()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val inputStream = request.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        println(messageBody)
        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)

        println(helloData.username)
        println(helloData.age)
        response.writer.write("ok")
    }
}