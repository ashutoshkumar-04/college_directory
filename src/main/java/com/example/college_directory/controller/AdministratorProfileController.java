package com.example.college_directory.controller;

import com.example.college_directory.model.AdministratorProfile;
import com.example.college_directory.service.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorProfileController {

    private final AdministratorProfileService administratorProfileService;

    @Autowired
    public AdministratorProfileController(AdministratorProfileService administratorProfileService) {
        this.administratorProfileService = administratorProfileService;
    }

    @GetMapping
    public List<AdministratorProfile> getAllAdministrators() {
        return administratorProfileService.getAllAdministrators();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministratorProfile> getAdministratorById(@PathVariable Long id) {
        AdministratorProfile administrator = administratorProfileService.getAdministratorById(id);
        return administrator != null ? ResponseEntity.ok(administrator) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdministratorProfile> createAdministrator(@RequestBody AdministratorProfile administratorProfile) {
        AdministratorProfile createdAdministrator = administratorProfileService.createAdministrator(administratorProfile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdministrator);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministratorProfile> updateAdministrator(@PathVariable Long id, @RequestBody AdministratorProfile administratorProfile) {
        AdministratorProfile updatedAdministrator = administratorProfileService.updateAdministrator(id, administratorProfile);
        return updatedAdministrator != null ? ResponseEntity.ok(updatedAdministrator) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        administratorProfileService.deleteAdministrator(id);
        return ResponseEntity.noContent().build();
    }
}
