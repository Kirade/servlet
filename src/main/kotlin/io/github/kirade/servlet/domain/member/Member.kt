package io.github.kirade.servlet.domain.member

class Member {
    var id: Long? = null
    var username: String? = null
    var age: Int? = null

    constructor(username: String, age: Int) {
        this.username = username
        this.age = age
    }
}