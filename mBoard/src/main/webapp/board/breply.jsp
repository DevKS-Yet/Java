<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글답변</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/write.css">
</head>
<body>
<section>
    <h1>게시글답변</h1>
    <hr>

    <form action="breply.do" name="reply" method="post" enctype="multipart/form-data">
      <table>
      <input type="hidden" name="bgroup" value="${boardVo.bgroup }">
      <input type="hidden" name="bstep" value="${boardVo.bstep }">
      <input type="hidden" name="bindent" value="${boardVo.bindent }">
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="bname">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle" value="<답변> ${boardVo.btitle }" readonly>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
          	<textarea name="bcontent" cols="50" rows="10"></textarea>
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
        <button type="submit" class="write">답변완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='blist.do?page=${param.page }&category=${param.category }&searchWord=${param.searchWord }'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>