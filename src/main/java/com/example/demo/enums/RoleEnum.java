package com.example.demo.enums;

public enum RoleEnum {
  ROLE_STAFF("Staff"),
  ROLE_STUDENT("Student"),
  ROLE_ADMIN("Admin");

  private String role;

  private RoleEnum(String r) {
    this.role = r;
  }

  public String getRole() {
    return this.role;
  }
}
