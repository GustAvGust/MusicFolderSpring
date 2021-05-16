function renderTable(objects, table) {
    innerHtml = '<tr>\n' +
        '               <th>Name</th>' +
        '               <th>Description</th>' +
        '            </tr>';

    for (let i = 0; i < objects.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <td>';
        innerHtml += objects[i]['name'];
        innerHtml += '  </td>';
        innerHtml += '  <td>';
        innerHtml += objects[i]['description'];
        innerHtml += '  </td>';
        innerHtml += '</tr>';
    }

    table.html(innerHtml);
}

function addAndShow(name, description, url) {
    $.ajax({
            type: "POST",
            url: url,
            data: {name: name, description: description},
            success: function (response) {
                renderTable(response, $('#table'));
            },
            dataType: "json",
            contentType: "application/json"
        }
    );
}

// function showTeas(page) {
//     $.ajax({
//             type: "GET",
//             url: "/teas?page=" + page,
//             success: function (response) {
//                 renderTable(response, $('#teas_table'));
//             },
//             dataType: "json",
//             contentType: "application/json"
//         }
//     );
// }
