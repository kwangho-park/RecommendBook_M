<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

  <title> Recommend book </title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset = "utf-8">
  <meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" content = "book">
  
  <!-- 전체 영역 단위 CSS -->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">

  <!-- 해당 page단위 CSS -->
  <link href="loginStyle.css" type="text/css" rel="stylesheet">

</head>



<body onload="initLogin()">

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
    
    <article>
    <h2>로그인 페이지에 오신것을 환영합니다 ^-^ </h2>
    </article>


	<article>
		
 		<form name = "loginClient" method = "post" action="loginFilter.jsp" onsubmit= "return login()">
 
    	<label class="loginInfo"> ID </label><input type = "text" 		name="loginId" id = "id" placeholder="문자입력">
    	<label class="loginInfo"> PW </label><input type = "password"	name="loginPw" id = "pw" placeholder="숫자입력">
    	
	   	<div align="center"><input type="submit" value="로그인"></div>
    
		</form>
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
  <script src="initLogin.js"></script>
  
  <!-- 로그인 유효성 검사 로직  --> 
  <script src="loginValidation.js"></script>
  
  
  
  <%-- 
  <!-- 로그인 filtering 로직 [old] -->
  <script src="loginFilter_old.js"></script>
  --%>

</body>

</html>