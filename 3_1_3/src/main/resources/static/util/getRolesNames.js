function getRolesNames(user) {
    return user.userRoles.map(function (role) {
        return role.role;
    });
}