package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Staff;
import com.example.demo.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
  public List<Student> findAllByDepartment(String department);

  public Optional<Student> findByUsername(String username);

}
