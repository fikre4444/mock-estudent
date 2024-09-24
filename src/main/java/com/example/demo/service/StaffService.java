package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Staff;
import com.example.demo.dto.StaffDto;
import com.example.demo.repository.StaffRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class StaffService {

  @Autowired
  private StaffRepository staffRepo;

  public List<StaffDto> getAllStaff() {
    List<Staff> staffs = staffRepo.findAll();
    return convertToDtoAll(staffs);
  }

  public List<StaffDto> getStaffByDepartment(String department) {
    List<Staff> staffs = staffRepo.findAllByDepartment(department);
    return convertToDtoAll(staffs);
  }

  public StaffDto getStaffByUsername(String username) {
    Optional<Staff> staffOpt = staffRepo.findByUsername(username);
    if (staffOpt.isPresent()) {
      return convertToDto(staffOpt.get());
    }
    return null;
  }

  private List<StaffDto> convertToDtoAll(List<Staff> staffs) {
    List<StaffDto> staffsDto = new ArrayList<>();
    for (Staff staff : staffs) {
      StaffDto staffDto = convertToDto(staff);
      staffsDto.add(staffDto);
    }
    return staffsDto;
  }

  private StaffDto convertToDto(Staff staff) {
    StaffDto staffDto = StaffDto.builder()
        .firstName(staff.getFirstName())
        .lastName(staff.getLastName())
        .username(staff.getUsername())
        .gender(staff.getGender().getGender())
        .department(staff.getDepartment())
        .courseLoad(staff.getCourseLoad())
        .email(staff.getEmail())
        .build();
    return staffDto;

  }

}
