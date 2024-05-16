package io.github.kirade.servlet.web.frontcontroller.v5.adapter

import io.github.kirade.servlet.web.frontcontroller.ModelView
import io.github.kirade.servlet.web.frontcontroller.v3.ControllerV3
import io.github.kirade.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter: MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV3
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV3

        val paramMap = createParamMap(request)
        return controller.process(paramMap)
    }

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        for (parameterName in request.parameterNames) {
            paramMap[parameterName] = request.getParameter(parameterName)
        }
        return paramMap
    }

}