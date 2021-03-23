function  reDrawUpdatedUser(user) {

    let tdFirstName = document.getElementById("user_"+user.id+"td-firstName-2")
    let tdLastName  = document.getElementById("user_"+user.id+"td-lastName-3")
    let tdLevel     = document.getElementById("user_"+user.id+"td-level-4" )
    let tdLogin     = document.getElementById("user_"+user.id+"td-login-5")
    let tdPassword  = document.getElementById("user_"+user.id+"td-password-6")
    let tdRoles     = document.getElementById("user_"+user.id+"td-role-7")

    tdFirstName.innerText   = user.firstName;
    tdLastName.innerText    = user.lastName;
    tdLevel.innerText       = user.level;
    tdLogin.innerText       = user.login;
    tdPassword.innerText    = user.password;
    tdRoles.innerText       = getRolesNames(user);

}
