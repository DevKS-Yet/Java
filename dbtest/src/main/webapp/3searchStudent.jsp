<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 검색</title>
		<script type="text/javascript">
	        function checkNumStuNo() {
	            var stuNo = document.getElementById("stuNo");
	            var checkStuNo = document.getElementById("checkStuNo");
	            if (stuNo.value == "") {
	                checkStuNo.innerHTML = "학번을 입력해주세요~";
	                stuNo.focus();
	                return false;
	            } else if (stuNo.value > 100 || stuNo.value < 0) {
	                checkStuNo.innerHTML = "학번은 1~999번까지입니다.";
	                stuNokor.focus();
	                return false;
	            } else if (isNaN(stuNo.value)) {
	                checkStuNo.innerHTML = "숫자만 입력해주세요~";
	                stuNo.focus();
	                return false;
	            } else {
	                checkStuNo.innerHTML = "";
	                return true;
	            }
	        }
	        
	        function checkForm(){
	        	if(checkNumStuNo()){
	        		document.getElementById("form").submit();
	        	} else {
	        		return false;
	        	}
	        }
	        
	        function index() {
	            location.href = "index.jsp";
	        }
		</script>
	</head>
	<body>
		<hr>
	    <form action="./searchStudentOk.jsp" method="get" id="form" onsubmit="return checkForm();">
	        <label for="stuNo">학번</label>
	        <input type="text" name="stuNo" id="stuNo" onkeyup="checkNumStuNo()"><span id=checkStuNo></span><br>
	        <label for="stuName">이름</label>
	        <input type="text" name="stuName" id="stuName"><br><br>
	        <label>입력한 정보</label><br>
	        <input type="radio" name="inputInfo" id="selStuNo" value="stuNo" checked><label for="selStuNo">학번</label>
	        <input type="radio" name="inputInfo" id="selStuName" value="stuName"><label for="selStuName">이름</label>
	        <input type="radio" name="inputInfo" id="selBoth" value="stuNo, stuName"><label for="selBoth">둘다</label><hr>
	        <input type="submit" value="검색">
	        <input type="reset" value="전체삭제">
	        <input type="button" value="검색취소" onclick="index()">
	    </form>
	</body>
</html>