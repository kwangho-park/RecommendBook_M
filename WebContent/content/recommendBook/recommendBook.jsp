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


 
<body onload="initSearchBook()">

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
  
    <!-- 도서취향 검색 및 추천 순위표-->
    <article>
      <iframe src="/RecommendBook_M/content/recommendBook/searchBook/searchBook.jsp" width = "35%" height = "400px"></iframe>
      <iframe src="/RecommendBook_M/content/recommendBook/rankingTable/rankingTable.jsp" width = "60%" height = "400px"></iframe>
	</article>

	<article>

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
				<th>난 이 도</th>
				<th>추천 점수</th>
				<th>삭 제</th>
			</tr>
		</thead>
				
		<tbody>
			<c:forEach items="${requestScope.listDto}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="/RecommendBook_M/content/post/viewPost.do?num=${dto.num}">${dto.bookName}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.title}</td>
					<td>${dto.bookType}</td>
					<td>${dto.favorite}</td>
					<td>${dto.bookLevel}</td>
					<td>${dto.score}</td>
					<td><a href="/RecommendBook_M/content/post/deletePost.do?num=${dto.num}">삭제</a></td>
				</tr>				
			</c:forEach>
		</tbody>
		
	</table>	
	<br>
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

  <script src="/RecommendBook_M/content/common/setMenuPanel.js" ></script>

</body>
</html>