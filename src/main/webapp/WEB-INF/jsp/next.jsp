<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>2nd page</title>

<style>
body {
	text-align: center;
}
</style>

</head>
<body>
	<h2>Hello Second World!</h2>
	<p>
	<%-- <h3>Welcome <%=request.getAttribute("naam") %> <%=request.getAttribute("techno") %></h3> JSP --%>
	
	Welcome ${naam}, Technology ${techno}
	<!-- EL-Expression Language JSTL -->
	
</body>
</html>