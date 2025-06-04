package com.techm.EmployeeAttandance.controller;

import com.techm.EmployeeAttandance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public String markAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        attendanceService.markAttendance(
                attendanceRequest.getEmployeeId(),
                attendanceRequest.getStatus(),
                LocalDate.now()
        );
        return "Attendance marked";
    }

    // DTO class for request body
    public static class AttendanceRequest {
        private Long employeeId;
        private String status;

        // getters and setters
        public Long getEmployeeId() { return employeeId; }
        public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }

}
