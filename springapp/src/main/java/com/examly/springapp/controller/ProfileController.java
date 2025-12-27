package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Profile;
import com.examly.springapp.service.ProfileService;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile saved = profileService.saveProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        profile.setProfileId(id);
        Profile updated = profileService.saveProfile(profile);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Profile>> getProfileByName(@PathVariable String name) {
        List<Profile> profiles = profileService.getProfilesByName(name);
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/search/{name}/{address}")
    public ResponseEntity<List<Profile>> getProfilesByNameAndAddress(@PathVariable String name, @PathVariable String address) {
        List<Profile> profiles = profileService.getProfilesByNameAndAddress(name, address);
        return ResponseEntity.ok(profiles);
    }
}
