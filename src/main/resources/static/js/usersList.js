$(document).ready(function () {
    getAllUsers();
});

function getAllUsers(){
    fetch("/admin/users1").then(function(response) {
        response.json().then(function(data) {
            let tableBody = $('#fillTableAllUsers tbody');
            tableBody.empty();
            $(data).each(function (i, user) {
                let stringRoles = "";
                $(user.roles).each(function (i, role) {
                    stringRoles += role.role + " ";
                });
                tableBody.append(`<tr> 
                    <td class="font-weight-normal">${user.id}</td> 
                    <td class="font-weight-normal">${user.username}</td> 
                    <td class="font-weight-normal">${user.password}</td>
                    <td class="font-weight-normal">${stringRoles}</td>                    
                    <td class="font-weight-normal">${user.firstname}</td> 
                    <td class="font-weight-normal">${user.lastname}</td>
                                           
                    <td><button id="updateButton" class="btn btn-info" role="button" data-toggle="modal" 
                    data-target="#exampleModal" onclick = 'modalForm(${user.id})'>Edit</button></td>
                                     
                    <td><button id="deleteButton" class="btn btn-danger" role="button" data-toggle="modal" 
                    data-target="#exampleModal2" onclick = 'modalForm2(${user.id})'>Delete</button></td>
                    </tr>`);
            })
        });
    });
}