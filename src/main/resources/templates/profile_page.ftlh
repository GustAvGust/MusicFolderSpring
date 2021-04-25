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
    <title>Profile</title>
</head>
<body>
<h1>Welcome in your profile, ${user.getFirstName()} ${user.getLastName()}</h1>
<input type="file" multiple='multiple' id="file" name="file" placeholder="File's name..."/>
<button onclick="sendFile()">
    Change Avatar
</button>

<img id="avatar" src="http://localhost:8080/files/${user.getAvatar().getStorageFileName()}">
<script src="/js/profile_page_script.js"></script>
</body>
</html>