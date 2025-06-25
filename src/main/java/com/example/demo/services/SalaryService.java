package com.example.demo.services;

import com.example.demo.entities.Salary;
import com.example.demo.entities.User;
import com.example.demo.repositories.SalaryRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    // Create
    @Transactional
    public Salary createSalary(Salary salary) {
        // Validate user exists
        User user = userRepository.findById(salary.getUser().getId())
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + salary.getUser().getId()));

        // Validate user constraints (e.g., @NotBlank on name)
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        salary.setUser(user);

        // Check for duplicate salary for the same user/month/year
        Optional<Salary> existingSalary = salaryRepository.findByUser_IdAndMonthAndYear(
                user.getId(), salary.getMonth(), salary.getYear());

        if (existingSalary.isPresent()) {
            throw new IllegalStateException("Salary for user ID " + user.getId() +
                    " for month " + salary.getMonth() +
                    " and year " + salary.getYear() +
                    " already exists. Consider updating instead.");
        }

        return salaryRepository.save(salary);
    }

    // Read All
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    // Read By ID
    public Optional<Salary> getSalaryById(Long id) {
        return salaryRepository.findById(id);
    }

    // Read By User ID
    public List<Salary> getSalariesByUserId(Long userId) {
        return salaryRepository.findByUser_Id(userId);
    }

    // Read By User ID, Month, Year
    public Optional<Salary> getSalaryByUserIdMonthAndYear(Long userId, Integer month, Integer year) {
        return salaryRepository.findByUser_IdAndMonthAndYear(userId, month, year);
    }

    // Read By Month and Year
    public List<Salary> getSalariesByMonthAndYear(Integer month, Integer year) {
        return salaryRepository.findByMonthAndYear(month, year);
    }

    // Read By Created At Range
    public List<Salary> getSalariesCreatedBetween(Date start, Date end) {
        return salaryRepository.findByCreatedAtBetween(start, end);
    }

    // Update
    @Transactional
    public Salary updateSalary(Long id, Salary salaryDetails) {
        Salary existingSalary = salaryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Salary not found with ID: " + id));

        // Update user if provided and different
        if (salaryDetails.getUser() != null && !existingSalary.getUser().getId().equals(salaryDetails.getUser().getId())) {
            User newUser = userRepository.findById(salaryDetails.getUser().getId())
                    .orElseThrow(() -> new NoSuchElementException("New User not found with ID: " + salaryDetails.getUser().getId()));
            // Validate new user
            Set<ConstraintViolation<User>> violations = validator.validate(newUser);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            existingSalary.setUser(newUser);
        }

        // Update other fields if provided
        Optional.ofNullable(salaryDetails.getAmount()).ifPresent(existingSalary::setAmount);
        Optional.ofNullable(salaryDetails.getMonth()).ifPresent(existingSalary::setMonth);
        Optional.ofNullable(salaryDetails.getYear()).ifPresent(existingSalary::setYear);
        Optional.ofNullable(salaryDetails.getBonus()).ifPresent(existingSalary::setBonus);
        Optional.ofNullable(salaryDetails.getNote()).ifPresent(existingSalary::setNote);

        return salaryRepository.save(existingSalary);
    }

    // Delete
    @Transactional
    public void deleteSalary(Long id) {
        if (!salaryRepository.existsById(id)) {
            throw new NoSuchElementException("Salary not found with ID: " + id);
        }
        salaryRepository.deleteById(id);
    }
}