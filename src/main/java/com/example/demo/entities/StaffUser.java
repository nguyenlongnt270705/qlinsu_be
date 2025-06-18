package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "StaffUsers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StaffUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;  // Đã mã hóa
    private String fullName;
    private String phone;
    private String role; // ROLE_EMPLOYEE.
    private boolean enabled;
    private int phone_number;
    private String address;
    private String language;

}
