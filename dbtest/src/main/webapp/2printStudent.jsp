<%@page import="student.DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="student.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	DAO sDAO = new DAO();
	ArrayList<DTO> sDTO = new ArrayList<DTO>();
	sDTO = sDAO.printStudent(sDTO);
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table, tr, td {
				border: 1px solid black;
				border-collapse: collapse;
			}
		</style>
	</head>
	<body>
	<%
		for(int i=0; i<sDTO.size();i++){
			if(i==0){
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
		<%
			}
	%>
			<tr>
				<td><%=sDTO.get(i).getStuNo() %></td>
				<td><%=sDTO.get(i).getName() %></td>
				<td><%=sDTO.get(i).getKor() %></td>
				<td><%=sDTO.get(i).getEng() %></td>
				<td><%=sDTO.get(i).getMath() %></td>
				<td><%=sDTO.get(i).getTotal() %></td>
				<td><%=sDTO.get(i).getAvg() %></td>
				<td><%=sDTO.get(i).getRank() %></td>
			</tr>
	<%
			if(i == sDTO.size()){
				%>
		</table>
		<%
			}
		}
	%>
		<a href="index.jsp"><h4>메인페이지로 돌아가기</h4></a>
	</body>

</html>