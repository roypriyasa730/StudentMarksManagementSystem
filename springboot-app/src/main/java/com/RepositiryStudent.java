package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot_app.StudentEntity;

@Repository
public interface RepositiryStudent extends JpaRepository<StudentEntity, Long> {
    // This interface will automatically provide CRUD operations for the Student
    // entity
    // Additional custom query methods can be defined here if needed

}
