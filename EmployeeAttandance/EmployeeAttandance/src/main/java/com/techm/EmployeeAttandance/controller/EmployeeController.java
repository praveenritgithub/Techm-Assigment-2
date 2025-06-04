package com.techm.EmployeeAttandance.controller;// com.techm.EmployeeAttandance.controller.EmployeeController.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public List<String> getAllEmployees() {
        // Dummy data for now
        return Arrays.asList("John Doe", "Jane Smith", "Alice Johnson");
    }
}
