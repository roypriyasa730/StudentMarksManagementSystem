package com.example.springboot_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositiryStudent extends JpaRepository<StudentEntity, Long> {
}
