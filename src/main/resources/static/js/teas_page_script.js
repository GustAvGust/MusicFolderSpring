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

function showTeas(name, description) {
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

addTeaButton.onclick = function () {
    showTeas($('#nameOfTea').val(), $('#descriptionOfTea').val());
};