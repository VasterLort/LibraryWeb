<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Add author:
<form action="MySecondServlet" method="post">
	<input type = "hidden" name="action" value="add_author"/>
	<input type="text" name="name"/>
	<input type="text" name="surname"/>
	<input type="number" name="age"/>
	<input type="submit" value="add new author">
</form>

</body>
</html>