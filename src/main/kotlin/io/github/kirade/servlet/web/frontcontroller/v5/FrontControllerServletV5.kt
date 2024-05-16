package io.github.kirade.servlet.web.frontcontroller.v5

import io.github.kirade.servlet.web.frontcontroller.MyView
import io.github.kirade.servlet.web.frontcontroller.v3.ControllerV3
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import io.github.kirade.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import io.github.kirade.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import io.github.kirade.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import io.github.kirade.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter
import io.github.kirade.servlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServlet", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServletV5: HttpServlet() {

    private val handlerMappingMap = mutableMapOf<String, Any>()
    private val handlerAdapters = mutableListOf<MyHandlerAdapter>()

    init {
        initHandlerMappingMap()
        initHandlerMappingAdapters()
    }

    private fun initHandlerMappingMap() {
        handlerMappingMap["/front-controller/v5/v3/members/new-form"] = MemberFormControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members/save"] = MemberSaveControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members"] = MemberListControllerV3()

        handlerMappingMap["/front-controller/v5/v4/members/new-form"] = MemberFormControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members/save"] = MemberSaveControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members"] = MemberListControllerV4()
    }

    private fun initHandlerMappingAdapters() {
        handlerAdapters.add(ControllerV3HandlerAdapter())
        handlerAdapters.add(ControllerV4HandlerAdapter())
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val handler = getHandler(request)
        if (handler == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val supportedAdapter = getHandlerAdapter(handler)
        val mv = supportedAdapter.handle(request, response, handler)
        val view = viewResolver(mv.viewName)
        view.render(mv.model, request, response)
    }

    private fun viewResolver(viewName: String) = MyView("/WEB-INF/views/${viewName}.jsp")

    private fun getHandlerAdapter(handler: Any): MyHandlerAdapter {
        for (adapter in handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter
            }
        }
        throw IllegalArgumentException("Handler Adapter not found: $handler")
    }

    private fun getHandler(request: HttpServletRequest): Any? {
        val requestURI = request.requestURI
        return handlerMappingMap[requestURI]
    }

}
