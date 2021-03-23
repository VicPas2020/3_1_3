function getCheckedCheckboxesForAdd() {

    return Array
        .from(document.getElementById("role-name-add").selectedOptions)
        .map(option => option.value);


}