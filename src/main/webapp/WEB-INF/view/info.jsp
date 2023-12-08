<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>

<h2>Info</h2>
<br>

<form:form action="saveUser" modelAttribute="user" method="post">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Age <form:input path="age"/>
    <form:errors path="age"/>
    <br>
    <br>
    <input type="submit" value="OK">

</form:form>


</body>
</html>
