function buildUsersTable() {

    let table = document.getElementById("tableOfAllUsers");
    let tbody = document.createElement('tbody');
    tbody.id = 'tbodyID'
    requestDataUsers("/admin/all");

    table.appendChild(tbody);


}
