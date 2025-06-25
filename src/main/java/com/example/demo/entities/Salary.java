// package com.example.demo.entities;

// import jakarta.persistence.*;
// import lombok.*;
// import java.math.BigDecimal;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "salaries")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Salary {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;
//     private BigDecimal amount;
//     private Integer month;
//     private Integer year;
//     private BigDecimal bonus;
//     private String note;
//     private LocalDateTime createdAt;
//     private LocalDateTime updatedAt;

//     // //Một người dùng có nhiều lương ( mapping 2 chiều)
//     // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//     // private List<Salary> salaries;

//     @PrePersist
//     public void prePersist() {
//         createdAt = LocalDateTime.now();
//         updatedAt = createdAt;
//     }

//     @PreUpdate
//     public void preUpdate() {
//         updatedAt = LocalDateTime.now();
//     }
// }
package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private BigDecimal amount;
    private Integer month;
    private Integer year;
    private BigDecimal bonus;
    private String note;
    private Date createdAt;
    private Date updatedAt;

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