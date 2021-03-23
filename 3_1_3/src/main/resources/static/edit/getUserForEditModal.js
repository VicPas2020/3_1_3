function getUserForEditModal(user) {


    document.getElementById("id-name-edit").value    = user.id;
    document.getElementById("first-name-edit").value = user.firstName;
    document.getElementById("last-name-edit").value  = user.lastName;
    document.getElementById("level-edit").value      = user.level;
    document.getElementById("login-edit").value      = user.login;
    document.getElementById("pass-edit").value       = user.password;

    let rolesNames = new Set(getRolesNames(user));

    if (rolesNames.has("ROLE_ADMIN")) {
        document.getElementById("checkboxAdminEdit").selected = true;
    } else {
        document.getElementById("checkboxAdminEdit").selected = false;
    }
    if (rolesNames.has("ROLE_USER")) {
        document.getElementById("checkboxUserEdit").selected = true;
    } else {
        document.getElementById("checkboxUserEdit").selected = false;
    }
}