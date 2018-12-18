<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Update Book:
<form action="MySecondServlet" method="post">
	<input type = "hidden" name="action" value="update_book"/>
	<input type="number" name="id_book"/>
	<input type="text" name="title"/>
	<input type="submit" value="update book">
</form>

</body>
</html>