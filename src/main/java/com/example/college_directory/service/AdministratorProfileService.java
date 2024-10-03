package com.example.college_directory.service;

import com.example.college_directory.model.AdministratorProfile;

import java.util.List;

public interface AdministratorProfileService {
    List<AdministratorProfile> getAllAdministrators();
    AdministratorProfile getAdministratorById(Long id);
    AdministratorProfile createAdministrator(AdministratorProfile administratorProfile);
    AdministratorProfile updateAdministrator(Long id, AdministratorProfile administratorProfile);
    void deleteAdministrator(Long id);
}
