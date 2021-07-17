<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>학생성적입력</title>
    <script type="text/javascript">
        function checkNumKor() {
            var kor = document.getElementById("kor");
            var checkKor = document.getElementById("checkKor");
            if (kor.value == "") {
                checkKor.innerHTML = "성적을 입력해주세요~";
                kor.focus();
                return false;
            } else if (kor.value > 100 || kor.value < 0) {
                checkKor.innerHTML = "점수는 0~100점만 입력해주세요~";
                kor.focus();
                return false;
            } else if (isNaN(kor.value)) {
                checkKor.innerHTML = "숫자만 입력해주세요~";
                kor.focus();
                return false;
            } else {
                checkKor.innerHTML = "";
                return true;
            }
        }
        function checkNumEng() {
            var eng = document.getElementById("eng");
            var checkEng = document.getElementById("checkEng");
            if (eng.value == "") {
                checkEng.innerHTML = "성적을 입력해주세요~";
                eng.focus();
                return false;
            } else if (eng.value > 100 || eng.value < 0) {
                checkEng.innerHTML = "점수는 0~100점만 입력해주세요~";
                eng.focus();
                return false;
            } else if (isNaN(eng.value)) {
                checkEng.innerHTML = "숫자만 입력해주세요~";
                eng.focus();
                return false;
            } else {
                checkEng.innerHTML = "";
                return true;
            }
        }
        function checkNumMath() {
            var math = document.getElementById("math");
            var checkMath = document.getElementById("checkMath");
            if (math.value == "") {
                checkMath.innerHTML = "성적을 입력해주세요~";
                math.focus();
                return false;
            } else if (math.value > 100 || math.value < 0) {
                checkMath.innerHTML = "점수는 0~100점만 입력해주세요~";
                math.focus();
                return false;
            } else if (isNaN(math.value)) {
                checkMath.innerHTML = "숫자만 입력해주세요~"
                math.focus();
                return false;
            } else {
                checkMath.innerHTML = "";
                return true;
            }
        }

        function checkForm() {
            alert("폼체크!");
            if (document.getElementById("stuName").value != "") {
                if (checkNumKor()) {
                    if (checkNumEng()) {
                        if (checkNumMath()) {
                            document.getElementById("form").submit();
                        }
                    }
                }
            }
            return false;
        }

        function index() {
            location.href = "index.jsp";
        }
    </script>
</head>

<body>
    <form action="./addStudentOk.jsp" method="post" id="form" onsubmit="return checkForm();">
        <label for="stuName">이름</label>
        <input type="text" name="stuName" id="stuName"><br>
        <label for="kor">국어</label>
        <input type="text" name="kor" id="kor" onkeyup="checkNumKor()"><span id=checkKor></span><br>
        <label for="eng">영어</label>
        <input type="text" name="eng" id="eng" onkeyup="checkNumEng()"><span id=checkEng></span><br>
        <label for="kor">수학</label>
        <input type="text" name="math" id="math" onkeyup="checkNumMath()"><span id=checkMath></span><br>
        <input type="submit" value="저장">
        <input type="reset" value="전체삭제">
        <input type="button" value="가입취소" onclick="index()">
    </form>
</body>

</html>