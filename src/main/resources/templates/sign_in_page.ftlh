<html>
<head>
    <title>SignIn</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div class="text-center">
        <h1>SignIn</h1>
    </div>
    <form method="post" action="/signIn">
        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="btn btn-primary btn-block" type="submit" value="Sign In">
            </div>
        </div>
    </form>
    <div class="text-center">
        <a href="/signUp">Sign Up</a>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>
</html>
