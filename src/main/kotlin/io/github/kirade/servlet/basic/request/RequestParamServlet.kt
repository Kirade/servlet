package io.github.kirade.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", value = ["/request-param"])
class RequestParamServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("전체 파라미터 조회 - start")
        for (entry in request.parameterMap) {
            var values = ""
            entry.value.forEach { values += it }
            println("${entry.key}: $values")
        }
        println("전체 파라미터 조회 - end")
    }
}