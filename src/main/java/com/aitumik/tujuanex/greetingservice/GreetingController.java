package com.aitumik.tujuanex.greetingservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class GreetingController {

    @Autowired
    private final GreetingsRepository greetingsRepository;

    GreetingController(GreetingsRepository repository) {
        this.greetingsRepository = repository;
    }

    @GetMapping("/greetings")
    List<Greeting> all() {
        return this.greetingsRepository.findAll();
    }

    @PostMapping("/greetings")
    Greeting newGreeting(@RequestBody Greeting newGreeting) {
        return this.greetingsRepository.save(newGreeting);
    }
}
