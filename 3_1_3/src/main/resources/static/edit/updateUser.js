function updateUser() {

    fetch("admin/put" ,
        {
            method: 'PUT', // Method itself
            headers: {
                "Accept": "application/json, text/plain, */*",
                "Content-type": "application/json"
            },

            body: JSON.stringify({
                id: $("#id-name-edit").val(),
                login: $("#login-edit").val(),
                password: $("#pass-edit").val(),
                firstName: $("#first-name-edit").val(),
                lastName: $("#last-name-edit").val(),
                level: $("#level-edit").val(),
                rolesInString: getCheckedCheckboxesForEdit()
            }),

        }).finally(()=> {proceedEdit(  $("#id-name-edit").val());   });

}