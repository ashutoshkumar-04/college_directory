package com.example.college_directory.data;

import com.example.college_directory.model.StudentProfile;
import com.example.college_directory.model.User;
import com.example.college_directory.repository.StudentProfileRepository;
import com.example.college_directory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create a new user
        User user = new User();
        user.setUsername("john.doe");
        user.setPassword("password");

        // Save the user to the database
        userRepository.save(user);

        // Create a new StudentProfile and link it to the User
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setDepartment("Computer Science");
        studentProfile.setEmail("john.doe@example.com");
        studentProfile.setName("John Doe");
        studentProfile.setUser(user); // Link the user to the student profile

        // Save the student profile to the database
        studentProfileRepository.save(studentProfile);
    }
}
