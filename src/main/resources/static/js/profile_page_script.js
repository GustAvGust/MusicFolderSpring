function sendFile() {
    let formData = new FormData();
    let files = ($('#file'))[0]['files'];
    [].forEach.call(files, function (file, i, files) {
        formData.append("avatar", file);
    });

    $.ajax({
        type: "POST",
        url: "/profile",
        data: formData,
        processData: false,
        contentType: false
    })
        .done(function (response) {
            let fileUrl = 'http://localhost:8080/files/' + response;
            console.log(fileUrl)
            $('#avatar').attr("src", fileUrl);
        })
        .fail(function () {
            alert('Error')
        });
}
