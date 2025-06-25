package com.example.demo.controllers;

import com.example.demo.entities.Salary;
import com.example.demo.services.SalaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/salaries")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    // Create: POST /api/salaries
    @PostMapping
    public ResponseEntity<Salary> createSalary(@Valid @RequestBody Salary salary) {
        try {
            Salary createdSalary = salaryService.createSalary(salary);
            return new ResponseEntity<>(createdSalary, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (IllegalStateException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating salary: " + e.getMessage());
        }
    }

    // Read All: GET /api/salaries
    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    // Read By ID: GET /api/salaries/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
        return salaryService.getSalaryById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Salary not found with ID: " + id));
    }

    // Read By User ID: GET /api/salaries/user/{userId}
    @GetMapping("/user/{userId}")
    public List<Salary> getSalariesByUserId(@PathVariable Long userId) {
        return salaryService.getSalariesByUserId(userId);
    }

    // Read By User ID, Month, Year: GET /api/salaries/user/{userId}/month/{month}/year/{year}
    @GetMapping("/user/{userId}/month/{month}/year/{year}")
    public ResponseEntity<Salary> getSalaryByUserIdMonthAndYear(
            @PathVariable Long userId,
            @PathVariable Integer month,
            @PathVariable Integer year) {
        return salaryService.getSalaryByUserIdMonthAndYear(userId, month, year)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Salary not found for user ID " + userId + " in " + month + "/" + year));
    }

    // Read By Month and Year: GET /api/salaries/month/{month}/year/{year}
    @GetMapping("/month/{month}/year/{year}")
    public List<Salary> getSalariesByMonthAndYear(
            @PathVariable Integer month,
            @PathVariable Integer year) {
        return salaryService.getSalariesByMonthAndYear(month, year);
    }

    // Read By Created At Range: GET /api/salaries/created-between?start={date}&end={date}
    @GetMapping("/created-between")
    public List<Salary> getSalariesCreatedBetween(
            @RequestParam String start,
            @RequestParam String end) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date startDate = formatter.parse(start);
            Date endDate = formatter.parse(end);
            return salaryService.getSalariesCreatedBetween(startDate, endDate);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use ISO 8601 (e.g., 2023-01-15T10:30:00).");
        }
    }

    // Update: PUT /api/salaries/{id}
    @PostMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @Valid @RequestBody Salary salaryDetails) {
        try {
            Salary updatedSalary = salaryService.updateSalary(id, salaryDetails);
            return ResponseEntity.ok(updatedSalary);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating salary: " + e.getMessage());
        }
    }

    // Delete: DELETE /api/salaries/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalary(@PathVariable Long id) {
        try {
            salaryService.deleteSalary(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting salary: " + e.getMessage());
        }
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Validation failed");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}