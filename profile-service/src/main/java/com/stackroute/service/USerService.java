package com.stackroute.service;

import com.stackroute.model.ProjectDto;
import com.stackroute.model.User;
import com.stackroute.repository.ProfileRepository;
import com.stackroute.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class USerService {

    ProfileRepository profileRepository;

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    public USerService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public User saveUser(User user) {
        return profileRepository.save(user);
    }

    public User updateUser(User user, String emailId) {
        Optional<User> user1 = profileRepository.findById(emailId);
        user1.get().setPhone(user.getPhone());
        user1.get().setName(user.getName());
        user1.get().setUserName(user.getUserName());
        user1.get().setDomain(user.getDomain());
        user1.get().setPhone(user.getPhone());
        user1.get().setGender(user.getGender());
        user1.get().setCity(user.getCity());
        user1.get().setDob(user.getDob());
        return profileRepository.save(user1.get());

    }

    public User getAllUser(String emailId) {
        System.out.println("inside service");


        return profileRepository.findByEmailId(emailId);


    }

    public ProjectDto getProject(String emailId) {
        System.out.println("inside project service");
        return projectRepository.findByEmailId(emailId);
    }
}


