package com.example.demo.repositories;

import com.example.demo.entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
    // Find salaries by user ID
    List<Salary> findByUser_Id(Long userId);

    // Find salaries by month and year
    List<Salary> findByMonthAndYear(Integer month, Integer year);

    // Find salary by user ID, month, and year
    @Query("SELECT s FROM Salary s WHERE s.user.id = :userId AND s.month = :month AND s.year = :year")
    Optional<Salary> findByUser_IdAndMonthAndYear(Long userId, Integer month, Integer year);

    // Find salaries created between two dates
    List<Salary> findByCreatedAtBetween(Date start, Date end);
}