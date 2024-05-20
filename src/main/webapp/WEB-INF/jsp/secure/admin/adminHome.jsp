<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Home</title>
    <script src="webjars/jquery/3.7.1/dist/jquery.min.js"></script>
    <link href="../../../../resources/JS/DataTables/datatables.min.css" rel="stylesheet">
    <script src="../../../../resources/JS/DataTables/datatables.min.js"></script>
    <link rel="Stylesheet" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>BIENVENIDO ADMIN</h1>

<table id="usersTable" class="display table table-striped text-center">
    <thead>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Username</th>
        <th>Total Amount</th>
    </tr>
    </thead>
</table>
<script>


    //peticion ajax
    $.ajax({
        url: "/adminAPI/usersList",
        dataType: 'json',
        type: "GET",
        success: function (data) {
            $('#usersTable').DataTable({
                responsive: true,
                data: data,
                columns: [
                    { data: 'idUsers', title: 'ID' },
                    { data: 'email', title: 'Email' },
                    { data: 'username', title: 'Username' },
                    { data: 'totalAmount', title: 'Total Amount' }
                ]
            });
        },
        error: function (error) {
            console.log(error);
        }
    });

</script>
</body>
</html>