package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/all")
  public ResponseEntity<?> getAll() {
    return ResponseEntity.ok(studentService.getAllStudent());
  }

  @GetMapping("/departments")
  public ResponseEntity<?> getDepartment(@RequestParam String departmentName) {
    System.out.println("in the contorller by dpearmtnet");
    return ResponseEntity.ok(studentService.getStudentByDepartment(departmentName));
  }

  @GetMapping("/byusername")
  public ResponseEntity<?> getByUsername(@RequestParam String username) {
    System.out.println("in the contorller by useranme");
    System.out.println("The username is " + username);
    StudentDto studentDto = studentService.getStudentByUsername(username);
    if (studentDto != null) {
      return ResponseEntity.ok(studentDto);
    } else {
      Map<String, String> errorResponse = new HashMap<>();
      errorResponse.put("message", "The user with the username '" + username + "' doesn't exist");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
  }

}
