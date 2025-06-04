package com.techm.EmployeeAttandance.service;

import com.techm.EmployeeAttandance.model.Attendance;
import com.techm.EmployeeAttandance.model.Employee;
import com.techm.EmployeeAttandance.repository.AttendanceRepository;
import com.techm.EmployeeAttandance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void markAttendance(Long employeeId, String status, LocalDate date) {
        Optional<Employee> empOpt = employeeRepository.findById(employeeId);
        if (empOpt.isEmpty()) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
        Employee employee = empOpt.get();

        // Find if attendance already exists for this employee and date
        Optional<Attendance> attendanceOpt = attendanceRepository.findByEmployeeAndDate(employee, date);

        Attendance attendance;
        if (attendanceOpt.isPresent()) {
            attendance = attendanceOpt.get();
            attendance.setStatus(status); // update status
        } else {
            attendance = new Attendance();
            attendance.setEmployee(employee);
            attendance.setDate(date);
            attendance.setStatus(status);
        }

        attendanceRepository.save(attendance);
    }

}
