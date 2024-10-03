package com.example.college_directory.service;

import com.example.college_directory.model.StudentProfile;

import java.util.List;

public interface StudentProfileService {
    List<StudentProfile> getAllStudents();
    StudentProfile getStudentById(Long id);
    StudentProfile createStudent(StudentProfile studentProfile);
    StudentProfile updateStudent(Long id, StudentProfile studentProfile);
    void deleteStudent(Long id);
}