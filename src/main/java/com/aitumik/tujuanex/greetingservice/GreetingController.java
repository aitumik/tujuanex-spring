package com.aitumik.tujuanex.greetingservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class GreetingController {

    @Autowired
    GreetingsRepository greetingsRepository;

    @GetMapping("/greetings")
    List<Greeting> all() {
        return this.greetingsRepository.findAll();
    }

    @PostMapping("/greetings")
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting newGreeting) {
        try {
            Greeting _greeting =  this.greetingsRepository.save(
                    new Greeting(newGreeting.getLanguage(), newGreeting.getText(), false)
            );
            return new ResponseEntity<>(_greeting,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
