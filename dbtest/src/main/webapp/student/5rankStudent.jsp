<%@page import="student.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
DAO sDAO = new DAO();
boolean check = sDAO.rankStudent();
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		if(check==true){
			%>
			<h3>등수처리 완료하였습니다.</h3>
			<h4><a href="index.jsp">메인페이지로</a></h4>
			<%
		} else {
			%>
			<h3>등수처리 실패하였습니다.</h3>
			<h4><a href="index.jsp">메인페이지로</a></h4>
			<%
		}
		%>
	</body>
</html>