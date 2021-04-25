function renderTable(teas, table) {
    innerHtml = '<tr>\n' +
        '               <th>Name</th>' +
        '               <th>Description</th>' +
        '            </tr>';

    for (let i = 0; i < teas.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <td>';
        innerHtml += teas[i]['name'];
        innerHtml += '  </td>';
        innerHtml += '  <td>';
        innerHtml += teas[i]['description'];
        innerHtml += '  </td>';
        innerHtml += '</tr>';
    }

    table.html(innerHtml);
}

function addAndShowTeas(name, description) {
    $.ajax({
            type: "POST",
            url: "/teas",
            data: {name: name, description: description},
            success: function (response) {
                renderTable(response, $('#teas_table'));
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

addTeaButton.onclick = function () {
    addAndShowTeas($('#nameOfTea').val(), $('#descriptionOfTea').val());
};