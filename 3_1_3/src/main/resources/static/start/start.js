$(document).ready(function () {

    buildUsersTable();
    document.getElementById("save-add").addEventListener("click", addNewUser);
    // document.getElementById("FormEditID").addEventListener("submit", updateUser);
    // Через onclick="addNewUser()" в html работает криво....

    $('#editFunction').on('click', function () { updateUser() });


    // три варианта вызова функции
    // 1) addEventListener("submit", addNewUser);
    // 2) $('#editFunction').on('click', function () { updateUser() });
    // 3) прямо в html кода:  < button type = "button" className = "btn btn-danger" onClick = "deleteUser()" > Delete < /button>





})