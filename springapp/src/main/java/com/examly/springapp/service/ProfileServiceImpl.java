package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Profile;
import com.examly.springapp.repository.ProfileRepo;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    
    @Autowired
    private ProfileRepo profileRepo;
    
    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepo.save(profile);
    }
    
    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }
    
    @Override
    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Profile> getProfilesByName(String name) {
        return profileRepo.findByFirstName(name);
    }
    
    @Override
    public List<Profile> getProfilesByNameAndAddress(String name, String address) {
        return profileRepo.findByFirstNameAndAddress(name, address);
    }
}
