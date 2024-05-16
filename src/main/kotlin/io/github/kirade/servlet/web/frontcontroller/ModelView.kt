package io.github.kirade.servlet.web.frontcontroller

class ModelView(var viewName: String) {
    var model = mutableMapOf<String, Any>()
}