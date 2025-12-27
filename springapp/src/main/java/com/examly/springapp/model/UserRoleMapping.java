package com.examly.springapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.HashMap;

@Entity
public class UserRoleMapping {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "role_id")
    private Long roleId;

    public UserRoleMapping() {}
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }
    
    @JsonProperty("user")
    public Map<String, Object> getUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        return user;
    }
    
    @JsonProperty("role")
    public Map<String, Object> getRole() {
        Map<String, Object> role = new HashMap<>();
        role.put("id", roleId);
        return role;
    }
    
    public void setUser(Map<String, Object> user) {
        if (user != null && user.get("id") != null) {
            this.userId = Long.valueOf(user.get("id").toString());
        }
    }
    
    public void setRole(Map<String, Object> role) {
        if (role != null && role.get("id") != null) {
            this.roleId = Long.valueOf(role.get("id").toString());
        }
    }
}
