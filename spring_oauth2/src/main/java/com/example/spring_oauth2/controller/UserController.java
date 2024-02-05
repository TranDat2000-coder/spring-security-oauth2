package com.example.spring_oauth2.controller;

import com.example.spring_oauth2.model.CustomerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.javadevjournal.com/spring-boot/spring-boot-oauth2/

@RestController
@RequestMapping("/api/customers")
public class UserController {

    @GetMapping("/customer/{userId}")
    public CustomerData getCustomerProfile(@PathVariable("userId") String userId) {
        return getCustomer(userId);
    }

    private CustomerData getCustomer(final String userId) {
        CustomerData customer = new CustomerData();
        customer.setEmail("contact-us@javadevjournal.com");
        customer.setFirstName("Demo");
        customer.setLastName("User");
        customer.setAge(21);
        customer.setId(userId);
        return customer;
    }
}
