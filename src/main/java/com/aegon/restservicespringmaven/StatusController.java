package com.aegon.restservicespringmaven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StatusController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // localhost:9091/greeting?name=Antonio --->
    @GetMapping("/status")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}