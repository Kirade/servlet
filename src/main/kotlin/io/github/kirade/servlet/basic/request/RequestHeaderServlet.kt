package io.github.kirade.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet: HttpServlet() {

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        printStartLine(request)
        printHeader(request)
    }

    private fun printHeader(request: HttpServletRequest) {
        println("---REQUEST Headers - start ---")

        for (headerName in request.headerNames) {
            println("$headerName: ${request.getHeader(headerName)}")
        }
        println("---REQUEST Headers - end ---")
        println()
    }

    private fun printStartLine(request: HttpServletRequest) {
        println("---REQUEST-LINE - start ---")
        println(request.method)
        println(request.protocol)
        println(request.scheme)
        println(request.requestURL)
        println(request.requestURI)
        println(request.queryString)
        println(request.isSecure)
        println("---REQUEST-LINE - end ---")
    }

}