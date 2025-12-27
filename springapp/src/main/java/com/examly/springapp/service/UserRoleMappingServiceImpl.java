package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.UserRoleMapping;
import com.examly.springapp.model.UserAccount;
import com.examly.springapp.model.Role;
import com.examly.springapp.repository.UserRoleMappingRepo;
import com.examly.springapp.repository.UserAccountRepo;
import com.examly.springapp.repository.RoleRepo;
import jakarta.persistence.EntityManager;
import java.util.List;

@Service
public class UserRoleMappingServiceImpl implements UserRoleMappingService {
    
    @Autowired
    private UserRoleMappingRepo userRoleMappingRepo;
    
    @Autowired
    private UserAccountRepo userAccountRepo;
    
    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public UserRoleMapping saveUserRoleMapping(UserRoleMapping userRoleMapping) {
        return userRoleMappingRepo.save(userRoleMapping);
    }
    
    @Override
    public List<UserRoleMapping> getAllUserRoleMappings() {
        return userRoleMappingRepo.findAll();
    }
    
    @Override
    public UserRoleMapping getUserRoleMappingById(Long id) {
        return userRoleMappingRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<UserRoleMapping> getUserRoleMappingsByUserId(Long userId) {
        return userRoleMappingRepo.findByUserId(userId);
    }
    
    @Override
    public UserRoleMapping getUserRoleMappingByUserIdAndRoleId(Long userId, Long roleId) {
        return userRoleMappingRepo.findByUserIdAndRoleId(userId, roleId);
    }
}
