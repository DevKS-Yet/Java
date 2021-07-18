<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 검색</title>
		<script type="text/javascript">
	        function checkNumStuNo(obj) {
	            var checkStuNo = document.getElementById("checkStuNo");
	            if (obj.value == "") {
	                checkStuNo.innerHTML = "학번을 입력해주세요~";
	                obj.focus();
	                return false;
	            } else if (obj.value > 100 || obj.value < 0) {
	                checkStuNo.innerHTML = "학번은 1~999번까지입니다.";
	                obj.focus();
	                return false;
	            } else if (isNaN(obj.value)) {
	                checkStuNo.innerHTML = "숫자만 입력해주세요~";
	                obj.focus();
	                return false;
	            } else {
	                checkStuNo.innerHTML = "";
	                return true;
	            }
	        }
	        
	        function checkNumStuName(obj){
	        	var checkStuName = document.getElementById("checkStuName");
	        	if (obj.value == "") {
	        		checkStuName.innerHTML = "이름을 입력해주세요~";
	        		obj.focus();
	        		return false;
	        	} else if (!isNaN(obj.value)) {
	        		checkStuName.innerHTML = "이름에 숫자가 들어가있네요? 자르반이세요?";
	        		obj.focus();
	        		return false;
	        	} else {
	        		checkStuName.innerHTML = "";
	        		return true;
	        	}
	        }
	        
	        function checkForm(){
	        	var selStuNo = document.getElementById("selStuNo");
				var selStuName = document.getElementById("selStuName");
				var selBoth = document.getElementById("selBoth");
	        	if(selStuNo.checked == true){
		        	if(checkNumStuNo(document.getElementById("stuNo"))){
		        		document.getElementById("form").submit();
		        	} else {
		        		return false;
		        	}
	        	} else if(selStuName.checked == true){
	        		if(checkNumStuName(document.getElementById("stuName"))){
	        			document.getElementById("form").submit();
	        		} else {
	        			return false;
	        		}
	        	} else {
	        		if(checkNumStuNo(document.getElementById("stuNo")) && checkNumStuName(document.getElementById("stuName"))){
	        			document.getElementById("form").submit();
	        		} else {
	        			return false;
	        		}
	        	}
	        	
	        }
	        
	        function index() {
	            location.href = "index.jsp";
	        }
		</script>
	</head>
	<body>
		<hr>
	    <form action="./updateStudentOk.jsp" method="get" id="form" onsubmit="return checkForm();">
	        <label for="stuNo">학번</label>
	        <input type="text" name="stuNo" id="stuNo" onkeyup="checkNumStuNo(this)"><span id=checkStuNo></span><br>
	        <label for="stuName">이름</label>
	        <input type="text" name="stuName" id="stuName" onkeyup="checkNumStuName(this)"><span id=checkStuName></span><br><br>
	        <label>입력한 정보</label><br>
	        <input type="radio" name="inputInfo" id="selStuNo" value="stuNo" checked><label for="selStuNo">학번</label>
	        <input type="radio" name="inputInfo" id="selStuName" value="stuName"><label for="selStuName">이름</label>
	        <input type="radio" name="inputInfo" id="selBoth" value="stuNo, stuName"><label for="selBoth">둘다</label><hr>
	        <input type="submit" value="수정">
	        <input type="reset" value="전체삭제">
	        <input type="button" value="수정취소" onclick="index()">
	    </form>
	</body>
</html>