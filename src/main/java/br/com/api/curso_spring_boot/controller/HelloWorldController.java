package br.com.api.curso_spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello-world")
public class HelloWorldController {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get1(@PathVariable("id") String id) {
        return "Hello GET1 " + id;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get2(@RequestParam("name") String name) {
        return "Hello World GET2 " + name;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String getInfoHelloWorld(@RequestBody String name) {
        return "Hello World " + name;
    }

}
