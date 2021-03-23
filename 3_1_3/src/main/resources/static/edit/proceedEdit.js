function proceedEdit(id) { // для EDIT

    $('#editUser').modal('hide');
    let url = new URL("http://localhost:9090/admin/oneUserID");
    let param = {id: id}
    url.search = new URLSearchParams(param).toString();

    fetch(url.toString())
        .then(r => r.json())
        .then(  reDrawUpdatedUser);


}