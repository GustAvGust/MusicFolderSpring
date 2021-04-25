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
<h3>Add your's tea in collection</h3>
<div>
    <input type="text" id="nameOfTea" placeholder="Name of Tea">
    <input type="text" id="descriptionOfTea" placeholder="Description of Tea">
    <input type="button" id="addTeaButton" value="Add Tea">
</div>

<table id="teas_table">
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <#list teas as tea>
        <tr>
            <td>${tea.name}</td>
            <td>${tea.description}</td>
        </tr>
    </#list>
</table>


<#list 0..page_number as x>
<#--    <button onclick="onclick=showTeas(${x})" value="${x}"/>-->
    <a href="/teas?page=${x}">${x}</a>
</#list>

<script src="/js/teas_page_script.js"></script>
</body>
</html>