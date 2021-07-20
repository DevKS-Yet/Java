<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <form action="./deleteDBOk.jsp" method="post">
        <label for="user">유저명</label>
        <input type="text" name="user" id="user" required><br>
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw"><br>
        <label for="host">호스트명</label>
        <input type="text" name="host" id="host"><br>
        <label for="port">포트번호</label>
        <input type="text" name="port" id="port"><br>
        <label for="sid">SID</label>
        <input type="text" name="sid" id="sid"><br>
        <input type="submit" value="삭제">
        <input type="button" value="취소" onclick="javascript:location.href='index.jsp'">
    </form>
</body>

</html>