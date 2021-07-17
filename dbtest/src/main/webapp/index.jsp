<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
  <h1>학생성적관리 시스템</h1>
  <div>
    <div><a href="./1addStudent.jsp"><button><span>1. 학생성적추가</span></button></a></div>
    <div><a href="./2printStudent.jsp"><button><span>2. 학생성적출력</span></button></a></div>
    <div><a href="./3searchStudent.jsp"><button><span>3. 학생성적검색</span></button></a></div>
    <div><a href="./4updateStudent.jsp"><button><span>4. 학생성적수정</span></button></a></div>
    <div><a href="./5rankStudent.jsp"><button><span>5. 등수처리</span></button></a></div>
    <div><a href="./8createDB.jsp"><button><span>8. 데이터베이스에 테이블 생성하기</span></button></a></div>
    <div><a href="./9deleteDB.jsp"><button><span>9. 데이터베이스에서 테이블 삭제하기</span></button></a></div>
    <div><a href="javascript:window.open('','_self').close();"><button><span>0. 시스템종료</span></button></a></div>
  </div>
</body>

</html>