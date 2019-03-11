<!-- search book의 inline frame 1 -->

<!-- page directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title> recommend today </title>
  
  <meta charset = "utf-8">
  <meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" content = "book">
  
  <!-- 전체 영역 단위 CSS -->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">
  
  <!-- 해당 페이지 단위 CSS -->
  <link href="searchBook.css" type="text/css" rel="stylesheet">
 

</head>


<body onload="init()">

  <!-- 도서를 추천받기 위한 정보 검색 리스트 -->
  <h2> 당신의 도서 취향은? </h2>    
  
  <p> 
  <label> 1. 분류 : </label> 
    <select id="bookType" name = "bookType" size = "1"> 
      <option value = "fiction"> 소설 </option>
      <option value = "essay"> 에세이/시 </option>
      <option value = "humanities"> 인문학 </option>
      <option value = "economy"> 경제경영 </option>
      <option value = "develop"> 자기계발 </option>
      <option value = "license"> 자격증 </option>
      <option value = "university"> 대학/전공서적 </option>
      <option value = "hobby"> 취미/레저/여행/뷰티 </option>
      <option value = "child"> 아동/청소년 </option>
      <option value = "cartoon"> 만화 </option>            
      <option value = "other"> 기타 </option>
    </select>
  </p>
  
  <p>  
  <label> 2. 취향 : </label> 
    <select id="favorite" name = "favorite" size = "1"> 
      <option value = "romance"> 달달한 로맨스 </option>
      <option value = "wit"> 재미있는 유머 </option>
      <option value = "story"> 탄탄한 스토리 </option>
      <option value = "detective"> 뇌섹남의 추리 </option>
      <option value = "action"> 짜릿한 액션 </option>
    </select>      
  </p>
  
  
  <p>
  <label> 3. 난이도 : </label> 
    <select id="level" name = "level" size = "1">
      <option value = "high"> 상 </option> 
      <option value = "normal"> 중 </option>
      <option value = "low"> 하 </option>
    </select>  
    
  </p>
     
  
  <input type="button" id="searchBtn"value="도서검색">


  <script src="printSearch.js"></script>
</body>
</html>
