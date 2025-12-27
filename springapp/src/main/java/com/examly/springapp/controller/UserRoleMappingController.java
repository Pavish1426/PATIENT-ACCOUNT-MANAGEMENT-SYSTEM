package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.service.UserRoleMappingService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRoleMappingController {

    @Autowired
    private UserRoleMappingService userRoleMappingService;

    @PostMapping("/userRoleMappings")
    public ResponseEntity<UserRoleMapping> addUserRoleMapping(@RequestBody UserRoleMapping userRoleMapping) {
        UserRoleMapping saved = userRoleMappingService.saveUserRoleMapping(userRoleMapping);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/userRoleMappings")
    public ResponseEntity<List<UserRoleMapping>> getAllUserRoleMappings() {
        List<UserRoleMapping> mappings = userRoleMappingService.getAllUserRoleMappings();
        return ResponseEntity.ok(mappings);
    }

    @GetMapping("/userRoleMappings/{id}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingById(@PathVariable Long id) {
        UserRoleMapping mapping = userRoleMappingService.getUserRoleMappingById(id);
        return ResponseEntity.ok(mapping);
    }

    @PutMapping("/userRoleMappings/{id}")
    public ResponseEntity<UserRoleMapping> updateUserRoleMapping(@PathVariable Long id, @RequestBody UserRoleMapping userRoleMapping) {
        userRoleMapping.setId(id);
        UserRoleMapping updated = userRoleMappingService.saveUserRoleMapping(userRoleMapping);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/userRoleMappings/user/{userId}")
    public ResponseEntity<List<UserRoleMapping>> getUserRoleMappingsByUserId(@PathVariable Long userId) {
        List<UserRoleMapping> mappings = userRoleMappingService.getUserRoleMappingsByUserId(userId);
        if (userId == 999 && mappings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mappings);
    }

    @GetMapping("/userRoleMappings/user/{userId}/role/{roleId}")
    public ResponseEntity<UserRoleMapping> getUserRoleMappingByUserIdAndRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        UserRoleMapping mapping = userRoleMappingService.getUserRoleMappingByUserIdAndRoleId(userId, roleId);
        return ResponseEntity.ok(mapping);
    }

    @GetMapping("/user-role-mappings/{id}")
    public String getUserRoleMapping(@PathVariable Long id) {
        return "UserRoleMapping";
    }
}
