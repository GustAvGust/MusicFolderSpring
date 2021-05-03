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
    <title>Document</title>
</head>
<body>
    <form method="post" resource="/teas/${.vars['tea-id']}">
        <input type="text" name="teaName" value="${tea.getName()}">
        <input type="text" name="teaDescription" value="${tea.getDescription()}">
        <input type="submit" value="Change Tea">
    </form>
</body>
</html>