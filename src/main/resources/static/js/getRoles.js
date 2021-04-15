$(document).ready(function () {
    getAllRolesForAddForm();
});

function getAllRolesForAddForm() {
    fetch("/admin/roles1").then(function (response) {
        response.json().then(function (data) {

            let selectBody = $('#newUser-role');
            $(data).each(function (i, role) {
                selectBody.append(`<option value="${role.id}">${role.role}</option>`);
            })



        })
    });
}