package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Staff;
import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

  public List<Staff> findAllByDepartment(String department);

  public Optional<Staff> findByUsername(String username);

}
