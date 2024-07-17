package com.home.resource_server;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

//    @GetMapping("/public")
//    public String homePage() {
//        return "Hello from Spring boot app";
//    }

    @GetMapping("/")
    @PreAuthorize("hasRole('read')")
    public String message() {
        return "Hello!";
    }
}
