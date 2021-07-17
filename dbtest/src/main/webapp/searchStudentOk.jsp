<%@page import="student.DTO"%>
<%@page import="student.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	int stuNo=0;
	String name="";
	DAO sDAO = new DAO();
	DTO sDTO = new DTO();
	
	String inputInfo = request.getParameter("inputInfo");
	if(inputInfo.equals("stuNo")){
		stuNo = Integer.parseInt(request.getParameter("stuNo"));
	} else if(inputInfo.equals("stuName")){
		name = request.getParameter("stuName");
	} else {
		stuNo = Integer.parseInt(request.getParameter("stuNo"));
		name = request.getParameter("stuName");
	}
	
	if(inputInfo.equals("stuNo")){
		sDTO = sDAO.searchStudentByStuNo(stuNo);
	} else if(inputInfo.equals("stuName")){
		sDTO = sDAO.searchStudentByName(name);
	} else {
		sDTO = sDAO.searchStudentByBoth(stuNo, name);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>학생검색</title>
</head>
<body>
<%
	if(sDTO.getStuNo()!=0 && sDTO.getName()!=null){
%>
	<table>
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>합계</td>
			<td>평균</td>
			<td>등수</td>
		</tr>
		<tr>
			<td><%=sDTO.getStuNo() %></td>
			<td><%=sDTO.getName() %></td>
			<td><%=sDTO.getKor() %></td>
			<td><%=sDTO.getEng() %></td>
			<td><%=sDTO.getMath() %></td>
			<td><%=sDTO.getTotal() %></td>
			<td><%=sDTO.getAvg() %></td>
			<td><%=sDTO.getRank() %></td>
		</tr>
	</table>
	<h4><a href="index.jsp">메인페이지로 돌아가기</a></h4>
<%
	} else if(sDTO.getStuNo()==0 && sDTO.getName()!=null){
%>
	<h3>검색된 학생이 여러명입니다. 이름을 확인하고 다시 검색해주세요.</h3>
	<h4><%=sDTO.getName() %></h4>
	<h4><a href="javascript:history.back()">검색페이지로 돌아가기</a></h4>
<%
	} else {
%>
	<h3>찾는 학생이 명단에 없습니다. 정보를 확인해주세요.</h3>
	<h4><a href="javascript:history.back()">검색페이지로 돌아가기</a></h4>
<%
	}
%>
</body>
</html>