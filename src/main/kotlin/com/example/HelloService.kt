package com.example

interface HelloService {
    fun sayHello(): String
}

class HelloServiceImpl : HelloService {
    override fun sayHello() = "Hello from HelloService!"
}