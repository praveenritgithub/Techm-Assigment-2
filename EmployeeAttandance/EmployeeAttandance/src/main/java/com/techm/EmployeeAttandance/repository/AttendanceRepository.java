package com.techm.EmployeeAttandance.repository;

import com.techm.EmployeeAttandance.model.Attendance;
import com.techm.EmployeeAttandance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployee(Employee employee);
    List<Attendance> findByEmployee_Department(String department);
    List<Attendance> findByEmployeeAndDateBetween(Employee employee, LocalDate startDate, LocalDate endDate);

    Optional<Attendance> findByEmployeeAndDate(Employee employee, LocalDate date);
}
