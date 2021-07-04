<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<script type="text/javascript">
		function checkForm(){
			return document.form.submit();
		}
	</script>
</head>

<body>
  <form action="./addStudent" method="post" name="form">
  	<div>
  	  <label for="stuNo">학생번호</label>
  	  <input type="text" name="stuNo" id="stuNo">
  	</div>
    <div>
      <label for="stuName">학생이름</label>
      <input type="text" name="stuName" id="stuName">
    </div>
    <div>
      <label for="stuKor">국어</label>
      <input type="text" name="stuKor" id="stuKor">
    </div>
    <div>
      <label for="stuEng">영어</label>
      <input type="text" name="stuEng" id="stuEng">
    </div>
    <div>
      <label for="stuMath">수학</label>
      <input type="text" name="stuMath" id="stuMath">
    </div>

    <div>
      <input type="button" onclick="checkForm()" value="저장">
      <input type="reset" value="전체삭제">
      <input type="button" onclick="Prev()" value="이전">
    </div>

  </form>
</body>

</html>