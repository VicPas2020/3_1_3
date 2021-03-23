function getCheckedCheckboxesForEdit() {

    return Array
        .from(document.getElementById("role-name-edit").selectedOptions)
        .map(option => option.value);


}