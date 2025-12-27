package com.examly.springapp.service;

import com.examly.springapp.model.Profile;
import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile);
    List<Profile> getAllProfiles();
    Profile getProfileById(Long id);
    List<Profile> getProfilesByName(String name);
    List<Profile> getProfilesByNameAndAddress(String name, String address);
}
