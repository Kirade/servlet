package io.github.kirade.servlet.web.frontcontroller.v1

import io.github.kirade.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1
import io.github.kirade.servlet.web.frontcontroller.v1.controller.MemberListControllerV1
import io.github.kirade.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV1", urlPatterns = ["/front-controller/v1/*"])
class FrontControllerServletV1: HttpServlet() {

    private val controllerMap = mutableMapOf<String, ControllerV1>()

    init {
        controllerMap["/front-controller/v1/members/new-form"] = MemberFormControllerV1()
        controllerMap["/front-controller/v1/members/save"] = MemberSaveControllerV1()
        controllerMap["/front-controller/v1/members"] = MemberListControllerV1()
    }

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("FrontControllerServletV1.service")

        val requestURI = request.requestURI
        val controller = controllerMap[requestURI]
        if (controller == null) {
            response.status = HttpServletResponse.SC_NOT_FOUND
            return
        }
        controller.process(request, response)
    }
}