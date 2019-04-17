<%-- 회원가입 정보 view --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

  <title> sign up </title>
  
  <meta charset = "utf-8">
  <meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" content = "book">

  <!-- 전체 영역 단위 CSS-->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">


  <!-- 해당 page단위 CSS -->
  <link href="signUpStyle.css" type="text/css" rel="stylesheet">

   

</head>


<%-- 회원가입 필터링 결과를 경고창으로 출력 --%>
<c:choose>
	<c:when test="${requestScope.signUpFilterResult == true}">
		<script>alert("회원가입 성공! good job!")</script>
	</c:when>
	<c:when test="${requestScope.signUpFilterResult == false}">
		<script>alert("중복된 아이디가 존재합니다! please, one more!")</script>
	</c:when>
</c:choose>




<body onload="initSignUp()">

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
  
    <h2> 회 원 가 입 </h2>

    <!-- 회원가입 양식 -->
    <article>
			<form name="signUpClient" method="post" action="signUpFilter.do" onsubmit="return signUpValidation()">
			
				<!-- 추후 영문입력으로 변경 -->
				<label class="signUpInfo"> 아 이 디&nbsp; : &nbsp;</label><input type="text" name="id" id="id" placeholder="문자">
					
				<%--[장기적 고민]
        		<input type="button" id="idCheckBtn" value="중복확인">  
        		--%>

				<label class="signUpInfo"> 비밀번호 : &nbsp;</label><input type="password" name="pw" id="pw" placeholder="문자 또는 숫자">
				<label class="signUpInfo"> 이&nbsp; &nbsp; 름&nbsp; : &nbsp;</label><input type="text" name="name" id="name" placeholder="문자"> 
				<label class="signUpInfo"> 생년월일 : &nbsp;</label><input type="date" name="birthday"id="birthday"><br>
				
				<label class="signUpInfo"> 이 메 일 : &nbsp;</label><input type="text" name="email01" id="email01" style="width:100px"> @ 
 
 						<input type="text" name="email02" id="email02">
 						
 						
						<select name="selectEmail" id="selectEmail">
							<option value="1" selected>직접입력</option> <option value="naver.com">naver.com</option> 
							<option value="hanmail.net">hanmail.net</option> <option value="hotmail.com">hotmail.com</option> 
							<option value="nate.com">nate.com</option> <option value="yahoo.co.kr">yahoo.co.kr</option> 
							<option value="empas.com">empas.com</option> <option value="dreamwiz.com">dreamwiz.com</option> 
							<option value="freechal.com">freechal.com</option> <option value="lycos.co.kr">lycos.co.kr</option> 
							<option value="korea.com">korea.com</option> <option value="gmail.com">gmail.com</option> 
							<option value="hanmir.com">hanmir.com</option> <option value="paran.com">paran.com</option> 
						</select>

				<br><br>
				<div style="text-align:center">- 주   소 -</div>
				<div class="addressLine">
				<span class="addressInfo"><input type="text" name="postCode" id="postCode" placeholder="우편번호"></span>
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
	
				<span class="addressInfo"><input type="text" name="roadAddress" id="roadAddress" placeholder="도로명주소"></span>
				<input type="text" name="jibunAddress" id="jibunAddress" placeholder="지번주소"><br>
									  
				<span class="addressInfo"><input type="text" name="detailAddress" id="detailAddress" placeholder="상세주소"></span>
				<input type="text" name="extraAddress" id="extraAddress" placeholder="참고항목">
				
				</div>
					
				
				<br>
				<div style="text-align:center"><input type="submit" value="회원가입신청"> <br></div>
				<br>
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
  <script src="initSignUp.js"></script>

  <!-- 입력한 회원가입 정보의 유효성 검사 -->
  <script src="signUpValidation.js"></script>
   
   
  <script src="/RecommendBook_M/content/common/setMenuPanel.js" ></script>
  
  <!-- daum post service (open API)-->
  <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

  <!--  daum API -->
  <script src="postCode.js"></script>
  
  
  <!-- jQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

  <!-- event email -->
  <script src="email.js"></script>
  
  
  
  
<%--
  <!-- id 중복여부를 확인하는 로직 -->
  <!-- [장기적 고민] 하나의 form에 2개의 submit처리방법은??--!>
  <script src="idFilter_old.js"></script>
--%>
  
  
<body>

</html>