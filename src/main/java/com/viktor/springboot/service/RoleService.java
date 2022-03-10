package com.viktor.springboot.service;


import com.viktor.springboot.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getByIdRole(int id);
    Role getRoleByName(String name);
}
