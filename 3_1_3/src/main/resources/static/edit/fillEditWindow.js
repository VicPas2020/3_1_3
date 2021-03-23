function fillEditWindow(login) {
//НОВЫЙ СПОСОБ
    let url = new URL("http://localhost:9090/admin/oneUser");

    let param = {login: login}

    url.search = new URLSearchParams(param).toString();

    fetch(url.toString())
        .then(r => r.json())
        .then( data=> getUserForEditModal(data));

}