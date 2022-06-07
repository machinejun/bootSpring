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
		<h1>for Example</h1>
	</header>
	<main>
		1에서 20까지 합은 ???<br/><br/>
		<!-- JSP 태그를 이용해서 1 + 2 + 3 ... 10 = 55 -->
		
		<%
		int result = 0;
		for(int i =1; i < 11; i++){
			if(i < 10){
				result += i;
				out.println(i + "+");
			}else{
				result += 10;
				
				out.println(i + " = " + result);
			}
	
		}
		%>
		<br/>
		<p>	result : <%=result %></p>
		
	</main>

</body>
</html>