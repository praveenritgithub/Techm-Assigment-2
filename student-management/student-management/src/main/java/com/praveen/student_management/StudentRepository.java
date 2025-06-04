package com.praveen.student_management;


import com.praveen.student_management.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContainingIgnoreCaseOrStudentClassContainingIgnoreCase(String name, String studentClass, Pageable pageable);
}