<%@page import="student.DTO"%>
<%@page import="student.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String stuName = request.getParameter("stuName");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int math = Integer.parseInt(request.getParameter("math"));
	
	DAO sDAO = new DAO();
	DTO sDTO = new DTO(stuName, kor, eng, math);
	int resultNum = sDAO.addStudent(sDTO);
%>
<html>
<head>
<meta charset="UTF-8">
<title>학생추가</title>
<script type="text/javascript">
	if(<%=resultNum %>==1){
		alert("학생정보 저장완료");
		location.href="./index.jsp";
	} else {
		alert("저장되지 않았습니다. 다시 입력해주세요");
		history.back(-1);
	}
</script>
</head>
<body>

</body>
</html>