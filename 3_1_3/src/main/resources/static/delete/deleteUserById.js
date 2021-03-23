function deleteUserById(id) {

    $.ajax({
        url: "/admin/delete",
        type: "DELETE",
        data: {id: id },
        success: function () {

            $('#'+"user-"+id).remove();

            $('#deleteUser').modal('hide');
        }
    });
}