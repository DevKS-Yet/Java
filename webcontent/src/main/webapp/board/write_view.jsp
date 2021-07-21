<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script type="text/javascript">
  	function checkForm(){
  		var bname = document.getElementById("bname");
  		var btitle = document.getElementById("btitle");
  		var bcontent = document.getElementById("bcontent");
  		
  		if(bname.value == ""){
  			alert("이름을 적어주세요.");
  			bname.focus();
  			return false;
  		} else if(btitle.value == ""){
  			alert("제목을 적어주세요.");
  			btitle.focus();
  			return false;
  		} else if(bcontent.value == ""){
  			alert("내용을 적어주세요.");
  			bcontent.focus();
  			return false;
  		}
  	}
  </script>
</head>
<body>
<section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="write.do" name="write" method="post" enctype="multipart/form-data" onsubmit="checkForm()">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname" id="bname">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" id="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" id="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="bupload" id="bupload">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='list.do'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>