<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>SignUp</title>
</head>
<body>
<div class="container">
    <div class="text-center">
        <h1>SignUp</h1>
    </div>
    <form method="post" action="/signUp">
        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="email" name="email" placeholder="Email">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="text" name="firstName" placeholder="First Name">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="text" name="lastName" placeholder="Last Name">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="text" name="phone" placeholder="Phone">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="form-control" type="password" name="password" placeholder="Password">
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-4">
                <input class="btn btn-success btn-block" type="submit" value="Sign Up">
            </div>
        </div>
    </form>
    <div class="text-center">
        <a href="/signIn">Sign In</a>
    </div>
</div>
</body>
</html>