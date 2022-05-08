package com.usb.UniversalSavingsBank.controllers;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public Pair<String, Integer> getTest() {
        return Pair.of("With", 123);
    }

    @PostMapping
    public void getPair(@RequestBody Pair<String, Integer> pair) {
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }
}
