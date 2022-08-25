package com.sistemaDistribuido.Banco.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "", produces = "application/json")
public class HelloWordController {

    @GetMapping("/saludar")
    public String sayHello() {
        return "Hello dev";
    }

}