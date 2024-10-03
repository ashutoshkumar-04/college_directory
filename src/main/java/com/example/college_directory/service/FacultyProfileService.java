package com.example.college_directory.service;

import com.example.college_directory.model.FacultyProfile;

import java.util.List;

public interface FacultyProfileService {
    List<FacultyProfile> getAllFaculties();
    FacultyProfile getFacultyById(Long id);
    FacultyProfile createFaculty(FacultyProfile facultyProfile);
    FacultyProfile updateFaculty(Long id, FacultyProfile facultyProfile);
    void deleteFaculty(Long id);
}
