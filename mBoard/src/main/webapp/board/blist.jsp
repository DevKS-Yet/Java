<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/notice_list.css">
  
  <script type="text/javascript">
  //글쓰기 성공 여부
	  <c:if test="${not empty resultWrite }">
	  	if(${resultWrite == 0}){
	  		alert("글쓰기에 실패했습니다.");
	  	} else if(${resultWrite == 1}){
	  		alert("글쓰기에 성공했습니다.")
	  	}
	  </c:if>
  //글수정 성공 여부
	  <c:if test="${not empty resultModify }">
		  if(${resultModify == 0}){
			  alert("글수정에 실패했습니다.");
		  } else if(${resultModify == 1}){
			  alert("글수정에 성공했습니다.");
		  }
	  </c:if>
  //답변 성공 여부
	  <c:if test="${not empty resultReply }">
		  if(${resultReply == 0}){
			  alert("글답변에 실패했습니다.");
		  } else if(${resultReply == 1}){
			  alert("글답변에 성공했습니다.");
		  }
	  </c:if>
  //글삭제 성공 여부
	  <c:if test="${not empty resultDelete }">
		  if(${resultDelete == 0}){
			  alert("글삭제에 실패했습니다.");
		  } else if(${resultDelete == 1}){
			  alert("글삭제에 성공했습니다.");
		  }
	  </c:if>
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="./blist.do" name="search" method="post">
        <select name="category" id="category">
          <option value="all" ${(category=="all")?"selected":"" }>전체</option>
          <option value="btitle" ${(category=="btitle")?"selected":"" }>제목</option>
          <option value="bcontent" ${(category=="bcontent")?"selected":"" }>내용</option>
        </select>

        <div class="title">
          <input type="text" name="searchWord" size="16" value="${searchWord }">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="15%">
        <col width="45%">
        <col width="15%">
        <col width="15%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 내용부분 -->
      <c:forEach var="boardVo" items="${list }">
      <tr>
        <td><span class="table-notice">${boardVo.bid }</span></td>
        <td class="table-title">
	        <a href="./bview.do?bid=${boardVo.bid }&page=${page }&category=${category }&searchWord=${searchWord }">
	        	<!-- 해당 레코드에서 bindent가 있을 시(답변글일시) -->
		        <c:forEach begin="1" end="${boardVo.bindent }">▶</c:forEach>
		        ${boardVo.btitle }
	        </a>
        </td>
        <td>${boardVo.bname }</td>
        <td>${boardVo.bdate }</td>
        <td>${boardVo.bhit }</td>
      </tr>
      </c:forEach>
      
    </table>

    <ul class="page-num">
    	<c:if test="${page > 1 }">
	      <a href="blist.do?page=1"><li class="first"></li></a>
    	</c:if>
    	<c:if test="${page <= 1 }">
	      <li class="first"></li>
    	</c:if>
    	<c:if test="${page > 1 }">
      	<a href="blist.do?page=${page-1 }"><li class="prev"></li></a>
    	</c:if>
    	<c:if test="${page <= 1 }">
      	<li class="prev"></li>
    	</c:if>
      	<c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
      		<c:if test="${pageNum != page }">
	      		<a href="blist.do?page=${pageNum }"><li class="num"><div>${pageNum }</div></li></a>
      		</c:if>
      		<c:if test="${pageNum == page }">
	      		<li class="num"><div>${pageNum }</div></li>
      		</c:if>
      	</c:forEach>
      <c:if test="${page < maxPage }">
				<a href="blist.do?page=${page+1 }"><li class="next"></li></a>
      </c:if>
      <c:if test="${page >= maxPage }">
				<li class="next"></li>
      </c:if>
      <c:if test="${page < maxPage }">
	      <a href="blist.do?page=${maxPage }"><li class="last"></li></a>
      </c:if>
      <c:if test="${page >= maxPage }">
	      <li class="last"></li>
      </c:if>
    </ul>

    <a href="./bwrite.jsp?page=${page }&category=${category }&searchWord=${searchWord }"><div class="write">쓰기</div></a>
  </section>

</body>
</html>