function fillDeleteWindow(login) {
    $.get("admin/oneUser",
        {login: login},
        function (user) {
            document.getElementById("userIdDel").value = user.id;
            document.getElementById("userLoginDel").value = user.login;
        });
}