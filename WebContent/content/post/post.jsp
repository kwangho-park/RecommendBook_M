<!-- page directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>post</title>

	<meta charset="UTF-8">
	<meta name="description" content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
	<meta name="keywords" content = "book">

    <!-- 전체 영역 단위 CSS -->
    <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">

    <!-- 해당 page단위 CSS -->
    <link href="postStyle.css" type="text/css" rel="stylesheet">

</head>



<body onload="initPost()">


  	<!-- main penel -->
  	<div class="mainPanel">		
  
  	<header>  
  		<h1 > Recommend book web site </h1>
  	</header>

	  <nav>
	  		<!-- menu panel -->  
			<%@ include file="/content/common/menuPanel.jspf"%>
	  </nav>
	  
    </div>
    
    
    
    
    <section>  

	<h2>게시글 작성</h2>
	
		<form name="postClient"  action="savePost.do" method="post" onsubmit="return postValidation()">
	
	
		<div class="postInfo"><label>도서명 : </label><input type="text" name="bookName" id="bookName"></div><br>
		<div class="postInfo"><label>작가명 : </label><input type="text" name="writer" id="writer"></div><br>
	
		<div class="postInfo"><input type="text" name="title" id="title" placeholder="제목을 작성해주세요" style="width:600px"></div><br>
	
		<div class="postInfo"><textarea name="content" id="content" cols="100" rows="10" placeholder="이곳에 게시글을 작성해주세요 ~ "></textarea></div>
		
		<hr>

		<h3>도서 분류를 선택해주세요^-^</h3>
	
		<div class="postInfo"> 
		 	<label> 1. 분류 : </label> 
		    <select name = "bookType" id="bookType" size = "1" > 
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
		</div><br>
	  
		<div class="postInfo"> 
		  	<label> 2. 취향 : </label> 
		    <select name = "favorite" size = "1"> 
				<option value = "">=====선택=====</option>
	      		<option value = "달달한 로맨스"> 달달한 로맨스 </option>
	   	   		<option value = "재미있는 유머"> 재미있는 유머 </option>
	      		<option value = "탄탄한 스토리"> 탄탄한 스토리 </option>
	      		<option value = "뇌섹남의 추리"> 뇌섹남의 추리 </option>
	      		<option value = "짜릿한 액션"> 짜릿한 액션 </option>
	    	</select>      
		</div><br>
	  
		<div class="postInfo"> 
	  		<label> 3. 난이도 : </label> 
	    	<select name = "bookLevel" size = "1">
 				<option value = "">=====선택=====</option>
	     	 	<option value = "상"> 상 </option> 
	      		<option value = "중"> 중 </option>
	      		<option value = "하"> 하 </option>
	    	</select>  
	    
		</div>
		<hr>
	
		<h3>추천 점수를 입력해주세요^-^</h3>
	
		<div class="postInfo"><input type="number" name="score" id="score" min="1" max="10" value="1"></div><br>
		
		<!-- 게시글 전송 버튼 -->
		<div align="center"><input type="submit" name="postBtn" value="게시글 등록"></div><br>
	
	</form>
	
  </section>
 
 
 
  <!-- web page loading 시 초기화 로직 -->
  <script src="initPost.js"></script>


  <!-- 게시글 정보 필터링-->
  <script src="postValidation.js"></script>

  <script src="/RecommendBook_M/content/common/setMenuPanel.js" ></script>

</body>

</html>