function renderTable(songs, table) {
    innerHtml = '<tr>\n' +
        '               <th>Name</th>' +
        '            </tr>';

    for (let i = 0; i < songs.length; i++) {
        innerHtml += '<tr>';
        innerHtml += '  <td>';
        //innerHtml += '      <input type="submit" value="Play" onclick="showFindSongs(null, ' + songs[i]['id'] + ', null)">\n';
        innerHtml += songs[i]['name'];

        innerHtml += '  </td>';
        innerHtml += '</tr>';
    }

    table.html(innerHtml);
}

function showFindSongs(substring) {
    $.ajax({
            type: "POST",
            url: "/main_page",
            data: {substring: substring},
            success: function (response) {
                renderTable(response, $('#music_table'));
            },
            dataType: "json",
            contentType: "application/json"
        }
    );
}

search_substring.oninput = function () {
    showFindSongs($('#search_substring').val());
};

//для того, чтобы в самом начале при нажатии на пустую поисковую строку, отобразились все песни
//TODO: отображались 10 последне проигранных песен
search_substring.onclick = function () {
    showFindSongs($('#search_substring').val());
};