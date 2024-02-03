package net.codejava.sbsecuritydemo.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {


    @GetMapping("/noauth")
    public ResponseEntity<String> noauth() {
        String responseBody = "Hello, this is response from non-authenticated route !";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Custom-Value");

        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }


    @GetMapping("/auth")
    public ResponseEntity<String> auth() {
        String responseBody = "Hello, this is response authenticated route !";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Custom-Value");

        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }
}
