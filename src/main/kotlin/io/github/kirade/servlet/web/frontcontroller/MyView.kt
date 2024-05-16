package io.github.kirade.servlet.web.frontcontroller

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MyView(private var viewPath: String) {

    fun render(request: HttpServletRequest, response: HttpServletResponse) {
        val dispatcher = request.getRequestDispatcher(viewPath)
        dispatcher.forward(request, response)
    }

}