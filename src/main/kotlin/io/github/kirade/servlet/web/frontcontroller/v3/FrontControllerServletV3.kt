package io.github.kirade.servlet.web.frontcontroller.v3

import io.github.kirade.servlet.web.frontcontroller.MyView
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberListControllerV3
import io.github.kirade.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerServletV3: HttpServlet() {

    private val controllerMap = mutableMapOf<String, ControllerV3>()

    init {
        controllerMap["/front-controller/v3/members/new-form"] = MemberFormControllerV3()
        controllerMap["/front-controller/v3/members/save"] = MemberSaveControllerV3()
        controllerMap["/front-controller/v3/members"] = MemberListControllerV3()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val requestURI = request.requestURI
        val controller = controllerMap[requestURI]
        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val paramMap = createParamMap(request)
        val mv = controller.process(paramMap)
        val view = viewResolver(mv.viewName)

        view.render(mv.model, request, response)
    }

    private fun viewResolver(viewName: String) = MyView("/WEB-INF/views/${viewName}.jsp")

    private fun createParamMap(request: HttpServletRequest): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        for (parameterName in request.parameterNames) {
            paramMap[parameterName] = request.getParameter(parameterName)
        }
        return paramMap
    }
}