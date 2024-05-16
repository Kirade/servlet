package io.github.kirade.servlet.web.frontcontroller.v3

import io.github.kirade.servlet.web.frontcontroller.ModelView

interface ControllerV3 {
    fun process(paramMap: Map<String, String>): ModelView
}