function proceedAdding(login) { // ДЛЯ ADD

    $('#new_user').removeClass('active');
    $('#home').removeClass('show active');

    $('#user_table').addClass('active')
    $('#menu1').addClass('show active')

    let url = new URL("http://localhost:9090/admin/oneUser ");

    let param = {login: login}

    url.search = new URLSearchParams(param).toString();

    fetch(url.toString())
        .then(r => r.json())
        .then(  fillRows)

}