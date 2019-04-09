<!-- page directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

  <title> search book </title>

  <meta charset = "utf-8">
  <meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" content = "book">

  
  <!-- 전체 영역 단위 CSS : 외부파일-->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">

  <!-- 해당 page단위 CSS -->
  <link href="/RecommendBook_M/content/recommendBook/recommendBookStyle.css" type="text/css" rel="stylesheet">
 

</head>

<%-- 로그인 필터링 결과를 경고창으로 출력 --%>
<c:choose>
	<c:when test="${requestScope.loginFilterFlag == true}">
		<script>alert("로그인 성공! nice job!")</script>
	</c:when>
	<c:when test="${requestScope.loginFilterFlag == false}">
		<script>alert("아이디 또는 비밀번호가 일치하지 않습니다! please, one more!")</script>
	</c:when>
</c:choose>

<%-- 특정 게시글의 저장 결과를 출력 --%>
<c:if test="${requestScope.saveSuccess == true }">
	<script>alert("게시글이 등록되었습니다! have nice day!!")</script>
</c:if>

<%-- 특정 게시글의 삭제 결과를 출력--%>
<c:if test="${requestScope.deleteSuccess == true }">
	<script>alert("게시글이 삭제되었습니다! have nice day!!")</script>
</c:if>

<%-- 특정 게시글의 수정 결과를 출력--%>
<c:if test="${requestScope.modifySuccess == true }">
	<script>alert("게시글이 수정되었습니다! have nice day!!")</script>
</c:if>


 
<body onload="initRecommendBook()">

  <!-- main penel -->
  <div class="mainPanel">		

  <header>  
  	<h1> Recommend book web site </h1>
  </header>


  <nav>
	<!-- menu panel -->  
	<%@ include file="/content/common/menuPanel.jspf"%>
  </nav>

  </div>  	



  <section>

  <div class="grid-container">
   <!-- ------------------------------------------------------------------------- -->  
  <article class="searchBlock">

        <!-- 도서검색 -->
 		 <h2> 당신의 도서 취향은? </h2>    
 
 		<!-- 주의 : 다양한 경로에서 해당 페이지에 접근하기 때문에... 루트기준ㅢ 상대경로로 저정해야 경로가 꼬이지않음...!! -->
 		 <form name="searchBook" action="/RecommendBook_M/content/recommendBook/searchBook.do" method="post">
 
  	     <p> 
  		 <label> 1. 분류 : </label> 
    		<select name = "bookType" size = "1"> 
    			<option value = "">=====선택=====</option>
		      	<option value = "소설"> 소설 </option>		
		 		<option value = "에세이/시"> 에세이/시 </option>
	    		<option value = "인문학"> 인문학 </option>
	   	  		<option value = "경제경영"> 경제경영 </option>
	      		<option value = "자기계발"> 자기계발 </option>
	      		<option value = "자격증"> 자격증 </option>
	      		<option value = "대학/전공서적"> 대학/전공서적 </option>
	      		<option value = "취미/레저/여행/뷰티"> 취미/레저/여행/뷰티 </option>
	      		<option value = "아동/청소년"> 아동/청소년 </option>
	      		<option value = "만화"> 만화 </option>            
	    		<option value = "기타"> 기타 </option>
    		</select>
  			</p>
  
  			<p>  
  			<label> 2. 취향 : </label> 
    		<select name = "favorite" size = "1">       
    			<option value = "">=====선택=====</option>
      			<option value = "달달한 로맨스"> 달달한 로맨스 </option>
	  			<option value = "유쾌한 코미디"> 유쾌한 코미디 </option>
	  			<option value = "짜릿한 무협/액션"> 짜릿한 무협/액션 </option>
	  			<option value = "뇌섹남의 공포/추리"> 뇌섹남의 공포/추리 </option>
	  			<option value = "화려한 판타지/SF"> 화려한 판타지/SF </option> 
    		</select>      
  			</p>
  
  
  			<p>
  			<label> 3. 난이도 : </label> 
    		<select name = "bookLevel" size = "1">
    			<option value = "">=====선택=====</option>
      			<option value = "상"> 상 </option> 
      			<option value = "중"> 중 </option>
      			<option value = "하"> 하 </option>
    		</select>  
    
    		</p>
     
    	<input type="submit" name="searchBtn" value="도서 추천"><br>
  
    </form>
 </article>
 
 
<!-- -------------------------------------------------------------------------------------- -->
 

<article class="rankingTableBlock">
   <table>
     <caption>추천 순위표</caption>
     
     <thead>
     <tr><th>순 위</th><th>도 서 명</th> <th>작 가 명</th> <th>추천 점수(평균)</th></tr> 
     </thead>

	 <tbody>
	 <c:if test="${requestScope.searchList != null }">
	 	<c:forEach var="dto" items="${requestScope.searchList}"  begin="0" end="5" step="1" varStatus="status">
	 		<tr>
	 			<td>${status.index + 1}</td>
	 			<td>${dto.bookName}</td>
	 			<td>${dto.writer}</td>
	 			<td>${dto.score }</td>		
	 		</tr>
	 	</c:forEach>
	 </c:if>
	 </tbody>	 
   </table>

</article>
 
 </div>
 
<!-- -------------------------------------------------------------------------------------- -->
 
 	
	<article class="postList">
	<br>
	<h2>게시글 목록</h2>
	<table>	
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>도 서 명</th>
				<th>작 가 명</th>
				<th>제 목</th>
				<th>분 류</th>
				<th>취 향</th>
				<th>난이도</th>
				<th>삭 제</th>
			</tr>
		</thead>
				
		<tbody>
			<c:forEach var="dto" items="${requestScope.postList}">
				<tr>
					<td>${dto.num}</td>
					<td>${dto.bookName}</td>
					<td>${dto.writer}</td>
					<td><a href="/RecommendBook_M/content/post/viewPost.do?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.bookType}</td>
					<td>${dto.favorite}</td>
					<td>${dto.bookLevel}</td>
					<td><a href="/RecommendBook_M/content/post/deletePost.do?num=${dto.num}">삭제</a></td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>	
	<br>

	<!-- paging -->
	<div class="countPage">
	<a href="/RecommendBook_M/content/recommendBook/recommendBook.do?pageNum=${requestScope.countPage[4] }" > [처음] </a>
	<a href="/RecommendBook_M/content/recommendBook/recommendBook.do?pageNum=${requestScope.countPage[2] }" > [이전] </a>
	
	<c:forEach var="pageNumber" begin="${requestScope.countPage[0] }" end="${requestScope.countPage[1] }">
	
		<a href="/RecommendBook_M/content/recommendBook/recommendBook.do?pageNum=${pageNumber }" > [${pageNumber }] </a>
		 
	</c:forEach>
	
	<a href="/RecommendBook_M/content/recommendBook/recommendBook.do?pageNum=${requestScope.countPage[3] }" > [다음] </a>
	<a href="/RecommendBook_M/content/recommendBook/recommendBook.do?pageNum=${requestScope.countPage[5] }" > [끝] </a>
	</div>
	
	</article>

	
  </section>
  
  
  <hr>

  <!-- reference contents -->
  <aside> 
    참고 : 박광호의 기술 블로그<a href = "http://solt.tistory.com" target = "_blank" title = "극논리주의 짠백이">
    (solt.tistory.com) </a>
  </aside>		


   <!-- 저작권 정보, 연락처 등-->
  <footer> 
    저작권 : recommend book web site는 <mark>박광호(웹 프로그래머)에게 저작권</mark>이 있습니다
  </footer>


  <!-- ----------------------------------------------------------------------------------------- -->
  
  <!-- web page loading 시 초기화 로직 -->
  <script src="initSearchBook.js"></script>
	

  <!-- 게시글을 업데이트하는 로직 -->
  <script src="printPost.js"></script>

  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

  <!-- menu panel을 동적으로 제어하는 logic -->
  <script src="/RecommendBook_M/content/common/setMenuPanel.js" ></script>

</body>
</html>