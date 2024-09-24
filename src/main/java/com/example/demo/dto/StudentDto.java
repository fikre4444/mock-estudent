package com.example.demo.dto;

import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

  private String firstName;
  private String lastName;
  private String username;
  private String gender;
  private String email;
  private String department;
  private String stream;
  private Float grade;

}
