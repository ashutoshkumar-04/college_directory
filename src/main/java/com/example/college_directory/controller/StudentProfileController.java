package com.example.college_directory.controller;

import com.example.college_directory.model.StudentProfile;
import com.example.college_directory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    @PostMapping
    public StudentProfile createStudent(@RequestBody StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return studentProfileRepository.findById(id)
                .map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentProfile> updateStudent(@PathVariable Long id, @RequestBody StudentProfile studentProfile) {
        return studentProfileRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(studentProfile.getName());
                    existingStudent.setEmail(studentProfile.getEmail());
                    existingStudent.setDepartment(studentProfile.getDepartment());
                    StudentProfile updatedStudent = studentProfileRepository.save(existingStudent);
                    return ResponseEntity.ok().body(updatedStudent);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        return studentProfileRepository.findById(id)
                .map(existingStudent -> {
                    studentProfileRepository.delete(existingStudent);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
