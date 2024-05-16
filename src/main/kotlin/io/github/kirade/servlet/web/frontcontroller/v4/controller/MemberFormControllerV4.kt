package io.github.kirade.servlet.web.frontcontroller.v4.controller

import io.github.kirade.servlet.web.frontcontroller.ModelView
import io.github.kirade.servlet.web.frontcontroller.v3.ControllerV3
import io.github.kirade.servlet.web.frontcontroller.v4.ControllerV4

class MemberFormControllerV4: ControllerV4 {
    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        return "new-form"
    }
}