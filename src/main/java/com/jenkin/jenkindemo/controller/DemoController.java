package com.jenkin.jenkindemo.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Somwiya!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye, Sowmiya!";
    }
}

