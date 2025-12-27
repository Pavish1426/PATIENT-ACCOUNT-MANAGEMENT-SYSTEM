package com.examly.springapp.service;

import com.examly.springapp.model.Role;
import com.examly.springapp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    private final Map<Long, Role> roleStore = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public Role addRole(Role role) {
        role.setRoleId(idCounter);
        roleStore.put(idCounter, role);
        idCounter++;
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<>(roleStore.values());
    }

    @Override
    public Page<Role> getAllRolesPaginated(Pageable pageable) {
        List<Role> roles = new ArrayList<>(roleStore.values());

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), roles.size());

        if (start > roles.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, roles.size());
        }

        List<Role> pageContent = roles.subList(start, end);

        return new PageImpl<>(pageContent, pageable, roles.size());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleStore.get(id);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role existing = roleStore.get(id);
        if (existing != null) {
            existing.setRoleName(role.getRoleName());
        }
        return existing;
    }

    @Override
    public void deleteRole(Long id) {
        roleStore.remove(id);
    }
}
