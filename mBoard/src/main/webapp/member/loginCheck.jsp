<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			<c:if test="${session_flag != 'success' }">
				alert("로그인 실패");
				location.href="./login.jsp";
			</c:if>
			<c:if test="${session_flag == 'success'}">
				alert("로그인 성공");
				location.href="../index.jsp";
			</c:if>
		</script>
	</head>
	<body>
	
	</body>
</html>