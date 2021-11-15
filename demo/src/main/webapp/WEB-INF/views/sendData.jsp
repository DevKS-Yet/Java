<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!--미구현상태-->
<script type="text/javascript">
	function init() {
		var name = new Array();
		<%for(int i=0; i<3; i++) { %>
		name.push("${name[0]}")
		<%}%>
		
		document.getElementById("show").innerHTML = name;
	}
</script>

</head>
<body onload="init();">

	<div id="show"></div>
	
</body>
</html>
