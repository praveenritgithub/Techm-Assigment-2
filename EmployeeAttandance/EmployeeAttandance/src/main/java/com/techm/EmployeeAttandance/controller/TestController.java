package com.techm.EmployeeAttandance.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/employees")
    public String testEmployees() {
        return "Employees endpoint is working!";
    }
}
