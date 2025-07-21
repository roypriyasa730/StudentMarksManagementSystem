package com.example.springboot_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private RepositiryStudent studentRepository;

    // GET - Get all students
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET - Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id) {
        Optional<StudentEntity> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST - Create a new student
    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@Valid @RequestBody StudentRequestBody requestBody) {
        // Set the entity fields from the request body
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(requestBody.getName());
        studentEntity.setEmail(requestBody.getEmail());
        studentEntity.setPhoneNumber(requestBody.getPhoneNumber());
        studentEntity.setAddress(requestBody.getAddress());
        studentEntity.setCourse(requestBody.getCourse());
        // Save the new student entity
        studentRepository.save(studentEntity);
        return new ResponseEntity<>(studentEntity, HttpStatus.CREATED);
    }

    // PUT - Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable("id") Long id,
            @Valid @RequestBody StudentRequestBody requestBody) {
        Optional<StudentEntity> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            StudentEntity existingStudent = studentData.get();
            existingStudent.setName(requestBody.getName());
            existingStudent.setEmail(requestBody.getEmail());
            existingStudent.setPhoneNumber(requestBody.getPhoneNumber());
            existingStudent.setAddress(requestBody.getAddress());
            existingStudent.setCourse(requestBody.getCourse());
            StudentEntity updatedStudent = studentRepository.save(existingStudent);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") Long id) {
        Optional<StudentEntity> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}