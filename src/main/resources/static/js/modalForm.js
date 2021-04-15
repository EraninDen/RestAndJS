function modalForm(id){
    let url = "/admin/updateUser1/" +id;
    fetch(url).then(function(response) {
        response.json().then(function(data) {
            $('#inputModalId').val(data.id);
            $('#inputModalUsername').val(data.username);
            $('#inputModalPassword').val(data.password);
            $('#inputModalFirstName').val(data.firstname);
            $('#inputModalLastName').val(data.lastname);


        });
    });
}