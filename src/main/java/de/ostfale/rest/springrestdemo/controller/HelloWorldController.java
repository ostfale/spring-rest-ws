package de.ostfale.rest.springrestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller for a hello world!
 * Created by Uwe Sauerbrei on 14.03.2018
 */
@RestController
public class HelloWorldController {


    // @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello Rest World!";
    }
}
