package ru.vicpas.spjs.service.roleService;

import ru.vicpas.spjs.model.Role;


public interface RoleService {

    Role getRoleByRoleName(String role);

    boolean empty();

    void save();

}
