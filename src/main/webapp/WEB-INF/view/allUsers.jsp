<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<body>

<h2>All Users</h2>

<table>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>age</th>
        <th>operations</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.age}</td>
            <td>
                <input type="button" value="update" onclick="window.location.href = '${updateButton}'">

                <input type="button" value="delete" onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="add" onclick="window.location.href = 'addUser'"/>

</body>
</html>
