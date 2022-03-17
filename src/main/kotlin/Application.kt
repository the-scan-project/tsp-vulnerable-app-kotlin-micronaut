package me.samoylenko.examples.vulnerable

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.runtime.Micronaut
import io.micronaut.views.View

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application.javaClass)
    }
}

@Controller("/hello")
class HelloController {

    @Get
    fun getName(@QueryValue name: String): String {
        return "Hello, $name"
    }
}

@Controller("/view")
class ViewController {

    @Get
    @View("hello")
    fun getView(@QueryValue name: String): HttpResponse<Map<String, String>> {
        return HttpResponse.ok(mapOf("name" to name))
    }
}
