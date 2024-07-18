<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link href="../css/style.css rel="stylesheet">
</head>
    <body>
        <form id="form-new" action="/persons" method="post">
            <label for="id">Id:</label>
            <input type="text" id="id" name="id"><br>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br>
            <label for="surname">Surname:</label>
            <input type="text" id="surname" name="surname"><br>
            <a href="#" onclick="document.getElementById('form-new').submit();">Create person</a>
        </form>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>
            <#list persons as person>
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                </tr>
            </#list>
        </table>

    </body>
</html>

