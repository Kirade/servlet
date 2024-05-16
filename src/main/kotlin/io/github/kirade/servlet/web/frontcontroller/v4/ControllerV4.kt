package io.github.kirade.servlet.web.frontcontroller.v4

import io.github.kirade.servlet.web.frontcontroller.ModelView

interface ControllerV4 {
    fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String
}