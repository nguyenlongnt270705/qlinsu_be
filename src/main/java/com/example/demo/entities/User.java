// package com.example.demo.entities;

// import java.util.Date;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.NotBlank;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "users")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;@NotBlank(message = "Name may not be blank")
//     private String email;
//     private String password;
//     private int age;
//     private String gender;
//     private String address;
//     private String refreshToken;
//     private Date createdAt;
//     private Date updatedAt;
//     private String createdBy;
//     private String updatedBy;
//     private Long role;
// }


package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name may not be blank")
    private String name;

    private String email;
    private String password;
    private int age;
    private String gender;
    private String address;
    private String refreshToken;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
    private Long role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
}