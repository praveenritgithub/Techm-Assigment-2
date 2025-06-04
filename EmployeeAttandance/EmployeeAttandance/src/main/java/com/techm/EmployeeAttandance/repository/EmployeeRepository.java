package com.techm.EmployeeAttandance.repository;

import com.techm.EmployeeAttandance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
