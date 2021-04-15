function modalForm2(id){
    let url = "/admin/user1/"+id;
    fetch(url).then(function(response) {
        response.json().then(function(data) {
            $('#inputModalId2').val(data.id);
            $('#inputModalUsername2').val(data.username);
            $('#inputModalPassword2').val(data.password);
            $('#inputModalFirstName2').val(data.firstname);
            $("#inputModalLastName2").val(data.lastname);


        });
    });
}