function fillRows(user) {

    let tdID        = document.createElement('td')
    let tdFirstName = document.createElement('td')
    let tdLastName  = document.createElement('td')
    let tdLevel     = document.createElement('td')
    let tdLogin     = document.createElement('td')
    let tdPassword  = document.createElement('td')
    let tdRoles     = document.createElement('td')

    tdID.innerText          = user.id;

    tdFirstName.innerText   = user.firstName;
    tdFirstName.setAttribute("id","user_"+user.id+"td-firstName-2")

    tdLastName.innerText    = user.lastName;
    tdLastName.setAttribute("id","user_"+user.id+"td-lastName-3" )

    tdLevel.innerText       = user.level;
    tdLevel.setAttribute("id","user_"+user.id+"td-level-4" )

    tdLogin.innerText       = user.login;
    tdLogin.setAttribute("id","user_"+user.id+"td-login-5" )

    tdPassword.innerText    = user.password;
    tdPassword.setAttribute("id","user_"+user.id+"td-password-6")

    tdRoles.innerText       = getRolesNames(user);
    tdRoles.setAttribute("id", "user_"+user.id+"td-role-7")


    // КНОПКА EDIT
    let tdEditButton = document.createElement('td');
    let inputEdit = document.createElement('input');
    inputEdit.type = "submit";
    inputEdit.className = "btn btn-primary";
    inputEdit.value = "Edit";
    inputEdit.dataset.toggle = "modal";
    inputEdit.dataset.target ="#editUser"
    inputEdit.onclick =function () {
        fillEditWindow(user.login);
    }
    tdEditButton.appendChild(inputEdit);


    // КНОПКА DELETE
    let tdDelete = document.createElement('td')
    let inputDelete = document.createElement('input')
    inputDelete.type = "submit";
    inputDelete.value = "Delete";
    inputDelete.className = "btn btn-danger";
    inputDelete.dataset.toggle = "modal";
    inputDelete.dataset.target = "#deleteUser"
    inputDelete.onclick = function () {
        fillDeleteWindow(user.login);
    }
    tdDelete.appendChild(inputDelete);


//////////// building  ////////
    let tr = document.createElement('tr')
    tr.setAttribute("id", "user-"+user.id);

    tr.appendChild(tdID);
    tr.appendChild(tdFirstName);
    tr.appendChild(tdLastName);
    tr.appendChild(tdLevel);
    tr.appendChild(tdLogin);
    tr.appendChild(tdPassword);
    tr.appendChild(tdRoles);
    tr.appendChild(tdEditButton);
    tr.appendChild(tdDelete);

    let divTbody = document.getElementById('tbodyID')
    divTbody.appendChild(tr);

    document.getElementById("FormAddID").reset();

}
