<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<#include "_navbar.ftlh">
<h3>Add your's collection in collection</h3>
<div>
    <input type="text" id="name" placeholder="Name of Collection">
    <input type="text" id="description" placeholder="Description of Collection">
    <input type="button" id="addCollectionButton" value="Add Collection">
</div>

<table id="table">
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <#list collections as collection>
        <tr>
            <td><a href="/collections/${collection.id}">${collection.name}</a></td>
            <td>${collection.description}</td>
        </tr>
    </#list>
</table>


<#list 0..page_number as x>
<#--    <button onclick="onclick=showCollections(${x})" value="${x}"/>-->
    <a href="/collections?page=${x}">${x}</a>
</#list>

<script src="/js/render_table_page_script.js"></script>
<script src="/js/collections_page_script.js"></script>
</body>
</html>