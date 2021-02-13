<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <title>Main Page</title>
</head>
<body>

<script>
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
</script>

<p>Home Page</p>
<input class="form-control col-4" id="search_substring" name="search_substring" type="text" placeholder="Search...">

<script> search_substring.oninput = function () {
        showFindSongs($('#search_substring').val());
    };

    //для того, чтобы в самом начале при нажатии на пустую поисковую строку, отобразились все песни
    //TODO: отображались 10 последне проигранных песен
    search_substring.onclick = function () {
        showFindSongs($('#search_substring').val());
    };
</script>

<div>
    <table id="music_table">

    </table>
</div>
</body>
</html>