<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>while Example</h1>
	</header>
	<main>
		<%!int number = 10;
	int count = 0;%>
		<%
		while (number > count) {
		%>

		화면에 출력값을 찍고 싶음 <b><%=count++%></b> <br />
		<%
		}
		%>


	</main>

</body>
</html>