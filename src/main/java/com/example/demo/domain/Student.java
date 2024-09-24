package com.example.demo.domain;

import com.example.demo.enums.GenderEnum;
import com.example.demo.enums.RoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "student")
public class Student extends Account {

  private String department;
  private String stream;
  private Float grade;

}
