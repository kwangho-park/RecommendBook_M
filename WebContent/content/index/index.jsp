<%@ page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>

<html>

<head>

  <title> Recommend book </title>

  <meta charset = "utf-8">
  <meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" content = "book">

  <!-- 전체 영역 단위 CSS -->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">

  <!-- 해당 page단위 CSS -->
  <link href="indexStyle.css" type="text/css" rel="stylesheet">
 
</head>



<body onload="init()">

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

    <!-- 인사말 및 회원가입 link -->
    <p>안녕하세요. <strong>도서 추천 웹 사이트에 오신것을 환영합니다 ^-^</strong><br>
      해당 웹 사이트를 이용하기 위해서 회원가입이 필요합니다. </p>
   
    </article>
 
 
    <!-- home page 메인 이미지 -->
    <img class = "HomeImg" src="/RecommendBook_M/content/reference/img/book-sea(free_commercial).jpg" width= "1000px" height = "500px">


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

  
  
  <!-- web page loading 시 초기화 로직 -->
  <script src="initIndex.js"></script>
  
  <script src="/RecommendBook_M/content/common/setMenuPanel.js" ></script>
  
  
</body>
</html>