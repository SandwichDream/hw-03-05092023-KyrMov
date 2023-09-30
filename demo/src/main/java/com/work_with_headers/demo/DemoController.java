package com.work_with_headers.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

    @GetMapping("/header")
    public String getHeader(HttpServletRequest httpsr) {
        return httpsr.getHeader("Header");
    }

    @GetMapping("/header2")
    public String getHeader2(@RequestHeader("Header2") String header) {
        return header;
    }

    @PostMapping("/post")
    public ResponseEntity<String> postHeader(@RequestBody String tea) {
        if (tea.toLowerCase().contains("green")) {
            return new ResponseEntity<>("Green tea", HttpStatus.OK); // Green
        } else if (tea.toLowerCase().contains("black")) {
            return new ResponseEntity<>("Black tea", HttpStatus.OK); // Black
        } else if (tea.toLowerCase().contains("java")) {
            return new ResponseEntity<>("I am a teapot", HttpStatus.I_AM_A_TEAPOT); // Java
        }
        return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST); // Invalid
    }

}