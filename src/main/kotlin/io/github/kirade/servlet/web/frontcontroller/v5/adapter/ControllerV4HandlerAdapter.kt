package io.github.kirade.servlet.web.frontcontroller.v5.adapter

import io.github.kirade.servlet.web.frontcontroller.ModelView
import io.github.kirade.servlet.web.frontcontroller.v4.ControllerV4
import io.github.kirade.servlet.web.frontcontroller.v5.MyHandlerAdapter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter: MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV4
    }

    override fun handle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV4

        val paramMap = createParamMap(request)
        val model = mutableMapOf<String, Any>()
        val viewName = controller.process(paramMap, model)
        val mv = ModelView(viewName)
        mv.model = model

        return mv
    }

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        for (parameterName in request.parameterNames) {
            paramMap[parameterName] = request.getParameter(parameterName)
        }
        return paramMap
    }
}