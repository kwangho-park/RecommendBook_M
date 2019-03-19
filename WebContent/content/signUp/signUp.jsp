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
  <link href="/RecommendBook_D/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">


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
  
    <h2> 회원가입 </h2>

    <!-- 회원가입 양식 -->
    <article>
	  <form name = "signUpClient" method = "post" action="signUpFilter.do" onsubmit= "return signUpValidation()">

        <label class="signUpInfo"> 아 이 디&nbsp; : &nbsp;</label>					<input type = "text" 	name="signUpId"			id="id" placeholder="문자로 입력해주세요">
        <%--[장기적 고민]
        <input type="button" id="idCheckBtn" value="중복확인">  
        --%>

        <label class="signUpInfo"> 비밀번호 : &nbsp;</label>							<input type = "password"name="signUpPw"			id="pw"  placeholder="숫자로 입력해주세요">
        <label class="signUpInfo"> 이&nbsp; &nbsp; 름&nbsp; : &nbsp;</label>			<input type = "text" 	name="signUpName"		id="name"	placeholder="당신의 이름은 무엇인가요?">
        <label class="signUpInfo"> 생년월일 : &nbsp;</label>							<input type = "date"  	name="signUpBrathday" 	id="brathday" >
        <label class="signUpInfo"> 이 메 일&nbsp; : &nbsp;</label>					<input type = "email" 	name="signUpEmail"		id="email" placeholder="이메일 형식에 맞춰주세요">
        <label class="signUpInfo"> 주&nbsp; &nbsp; &nbsp;소&nbsp; : &nbsp;</label>	<input type = "text" 	name="signUpAddress"	id="address" placeholder="거주지가 어디신가요?">

		
        <label class="signUpInfo"> 가입경로&nbsp; : &nbsp;</label> 
        <select name = "signUpProcess" size = "1"> 
  		  <option value = "">=====선택=====</option>
          <option value = "인터넷 검색"> 인터넷 검색 </option>
          <option value = "지인추천"> 지인추천 </option>
          <option value = "광고"> 광고 </option>
          <option value = "기타"> 기타 </option>
        </select>


		<div class="mail">
		
        <fieldset>
          <legend> 광고성 메일 수신여부 </legend>
          <label> 수신 : </label>	<input type = "radio" name = "signUpAdvertising" value="수신" checked> 
          <label> 미수신 : </label>	<input type = "radio" name = "signUpAdvertising" value="미수신">
        </fieldset>

        <br>
         <input type="submit" value="회원가입신청">     
        <br>
        
        </div>
        

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
  
<%--
  <!-- session storage에 저장하는 로직 -->
  <script src="saveInfo_old.js"></script>
   

  <!-- id 중복여부를 확인하는 로직 -->
  <!-- [장기적 고민] 하나의 form에 2개의 submit처리방법은??--!>
  <script src="idFilter_old.js"></script>
--%>
  
  
<body>

</html>