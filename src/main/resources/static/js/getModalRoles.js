$(document).ready(function () {
    getAllRolesForModal();
});

function getAllRolesForModal() {
    fetch("/admin/roles1").then(function (response) {
        response.json().then(function (data) {

            let selectBody = $('#inputModalRole');
            $(data).each(function (i, role) {
                selectBody.append(`<option value="${role.id}">${role.role}</option>`);
            })

            let selectBody2 = $('#inputModalRole2');
            $(data).each(function (i, role) {
                selectBody2.append(`<option value="${role.id}">${role.role}</option>`);
            })
        })
    });
}