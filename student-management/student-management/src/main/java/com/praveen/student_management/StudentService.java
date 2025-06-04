package com.praveen.student_management;

import com.praveen.student_management.Student;
import com.praveen.student_management.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Page<Student> listAll(int pageNumber, String keyword) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, Sort.by("studentId").ascending());

        if (keyword != null && !keyword.isEmpty()) {
            return repo.findByNameContainingIgnoreCaseOrStudentClassContainingIgnoreCase(keyword, keyword, pageable);
        }
        return repo.findAll(pageable);
    }

    public void save(Student student) {
        repo.save(student);
    }

    public Optional<Student> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
