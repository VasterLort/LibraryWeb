<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Id author:
<form action="MySecondServlet" method="post">
	<input type = "hidden" name="action" value="view_books_of_author"/>
	<input type="number" name="id_author"/>
	<input type="submit" value="search author"/>
</form>

</body>
</html>