package io.github.kirade.servlet.web.frontcontroller.v2

import io.github.kirade.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2
import io.github.kirade.servlet.web.frontcontroller.v2.controller.MemberListControllerV2
import io.github.kirade.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/front-controller/v2/*"])
class FrontControllerServletV2: HttpServlet() {

    private val controllerMap = mutableMapOf<String, ControllerV2>()

    init {
        controllerMap["/front-controller/v2/members/new-form"] = MemberFormControllerV2()
        controllerMap["/front-controller/v2/members/save"] = MemberSaveControllerV2()
        controllerMap["/front-controller/v2/members"] = MemberListControllerV2()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val requestURI = request.requestURI
        val controller = controllerMap[requestURI]
        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }
        val view = controller.process(request, response)
        view.render(request, response)
    }
}