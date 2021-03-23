function addNewUser() {

    fetch("admin/post" ,
        {
            method: 'POST',
            headers: {
                "Accept": "application/json, text/plain, */*",
                "Content-type": "application/json"
            },

            body: JSON.stringify({

                firstName: $("#first-name-add").val(),
                lastName:  $("#last-name-add").val(),
                level:     $("#level-add").val(),
                login:     $("#login-add").val(),
                password:  $("#pass-add").val(),
                rolesInString: getCheckedCheckboxesForAdd()

            }),

        })  .finally(()=> {proceedAdding($("#login-add").val()); });

}