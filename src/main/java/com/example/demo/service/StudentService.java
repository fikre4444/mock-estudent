package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.dto.StudentDto;
import com.example.demo.repository.StudentRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepo;

  public List<StudentDto> getAllStudent() {
    List<Student> students = studentRepo.findAll();
    return convertToDtoAll(students);
  }

  public List<StudentDto> getStudentByDepartment(String department) {
    List<Student> students = studentRepo.findAllByDepartment(department);
    return convertToDtoAll(students);
  }

  public StudentDto getStudentByUsername(String username) {
    Optional<Student> studentOpt = studentRepo.findByUsername(username);
    if (studentOpt.isPresent()) {
      return convertToDto(studentOpt.get());
    }
    return null;
  }

  private List<StudentDto> convertToDtoAll(List<Student> students) {
    List<StudentDto> studentsDto = new ArrayList<>();
    for (Student student : students) {
      StudentDto studentDto = convertToDto(student);
      studentsDto.add(studentDto);
    }
    return studentsDto;
  }

  private StudentDto convertToDto(Student student) {
    StudentDto studentDto = StudentDto.builder()
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .username(student.getUsername())
        .gender(student.getGender().getGender())
        .department(student.getDepartment())
        .grade(student.getGrade())
        .stream(student.getStream())
        .email(student.getEmail())
        .build();
    return studentDto;

  }

}
