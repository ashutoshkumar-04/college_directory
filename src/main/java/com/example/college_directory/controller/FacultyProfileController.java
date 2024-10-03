package com.example.college_directory.controller;

import com.example.college_directory.model.FacultyProfile;
import com.example.college_directory.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyProfileController {

    private final FacultyProfileService facultyProfileService;

    @Autowired
    public FacultyProfileController(FacultyProfileService facultyProfileService) {
        this.facultyProfileService = facultyProfileService;
    }

    @GetMapping
    public List<FacultyProfile> getAllFaculties() {
        return facultyProfileService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyProfile> getFacultyById(@PathVariable Long id) {
        FacultyProfile faculty = facultyProfileService.getFacultyById(id);
        return faculty != null ? ResponseEntity.ok(faculty) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FacultyProfile> createFaculty(@RequestBody FacultyProfile facultyProfile) {
        FacultyProfile createdFaculty = facultyProfileService.createFaculty(facultyProfile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFaculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyProfile> updateFaculty(@PathVariable Long id, @RequestBody FacultyProfile facultyProfile) {
        FacultyProfile updatedFaculty = facultyProfileService.updateFaculty(id, facultyProfile);
        return updatedFaculty != null ? ResponseEntity.ok(updatedFaculty) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyProfileService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
