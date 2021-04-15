$(document).ready(function () {
    $('#deleteUser').click(function () {
        fetchPostDeleteUser();
    });

    function fetchPostDeleteUser() {
        let roleValue = "";
        let role = document.getElementById("inputModalRole");
        if (role[role.selectedIndex].value === 2) {
            roleValue = "ROLE_ADMIN";
        } else {
            roleValue = "ROLE_USER";
        }



        // Create JSON object
        let addData = {
            id: $('#inputModalId2').val(),
            username: $('#inputModalUsername2').val(),
            password: $('#inputModalPassword2').val(),
            firstname: $('#inputModalFirstName2').val(),
            lastname: $('#inputModalLastName2').val(),
            roles: [{
                id: role[role.selectedIndex].value,
                role: roleValue,
                authority: roleValue
            }]

        };

        let url = "/admin/user1/"+$('#inputModalId2').val();
        // DO PUT
        fetch(url, {
            method: 'delete',
            body: JSON.stringify(addData),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function () {
            document.location.reload();
        })
    }
});