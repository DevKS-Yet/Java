<%@page import="db.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String user = request.getParameter("user");
	String pw = request.getParameter("pw");
	boolean result = false;
	
	DB sDB = new DB();
	result = sDB.deleteDB(user, pw);
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		if(result==true){
			%>
			<h3>테이블 및 시퀀스가 삭제 되었습니다.</h3>
			<h4><a href="index.jsp">메인페이지로</a></h4>
			<%
		} else {
			%>
			<h3>테이블 또는 시퀀스 삭제에 실패하였습니다.</h3>
			<h4><a href="./9deleteDB.jsp">테이블삭제 페이지로</a></h4>
			<h4><a href="index.jsp">메인페이지로</a></h4>
			<%
		}
		%>
	</body>
</html>