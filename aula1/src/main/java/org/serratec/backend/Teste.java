package org.serratec.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Teste {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello world";
    }

}