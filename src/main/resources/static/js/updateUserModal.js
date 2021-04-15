$(document).ready(function () {
    $('#updateUser').click(function () {
        fetchPostUpdateUser();
    });

    function fetchPostUpdateUser() {
        let roleValue = "";
        let role = document.getElementById("inputModalRole");
        if (role[role.selectedIndex].value === 2) {
            roleValue = "ROLE_ADMIN";
        } else {
            roleValue = "ROLE_USER";
        }

        // Create JSON object
        let addData = {
            id: $('#inputModalId').val(),
            username: $('#inputModalUsername').val(),
            password: $('#inputModalPassword').val(),
            firstname: $('#inputModalFirstName').val(),
            lastname: $('#inputModalLastName').val(),
            roles: [{
                id: role[role.selectedIndex].value,
                role: roleValue,
                authority: roleValue
            }]
        };

        let url = "/admin/updateUser1/"+$('#inputModalId').val();
        // DO PUT
        fetch(url, {
            method: 'put',
            body: JSON.stringify(addData),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function () {
            document.location.reload();
        })
    }
});