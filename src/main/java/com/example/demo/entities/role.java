package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Table(name = "roles")
@Data

public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String roleName;@NotBlank(message = "Name may not be blank")
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private Long role;
}
