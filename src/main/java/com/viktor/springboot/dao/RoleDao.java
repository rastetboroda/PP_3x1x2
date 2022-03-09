package com.viktor.springboot.dao;

import com.viktor.springboot.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();
    Role getByIdRole(int id);
}
