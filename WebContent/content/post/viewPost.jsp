<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>


<html>
<head>
	<title>post view</title>

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

	<h2>게시글 수정</h2>

		<form name="postClient"  action="modifyPost.do" method="post" onsubmit="return postValidation()">
	
	
		<!-- [추후] 변경예정 -->
		<!-- [hidden] 게시글 수정을 위한 DB table의 num값을 보관 -->
		<input type="hidden" name="num" value="${requestScope.dto.num}">
	
	
		<div class="postInfo"><label>도서명 : </label><input type="text" name="bookName" id="bookName" value="${requestScope.dto.bookName }"></div><br>
		<div class="postInfo"><label>작가명 : </label><input type="text" name="writer"   id="writer" value="${requestScope.dto.writer }"></div><br>
	
		<div class="postInfo"><input type="text" name="title" id="title" style="width:600px" value="${requestScope.dto.title }"></div><br>
	
		<div class="postInfo"><textarea name="content" id="content" cols="100" rows="10">${requestScope.dto.content }</textarea></div>
		
		<hr>

		<h3>도서 분류를 선택해주세요^-^</h3>
	
		<div class="postInfo"> 
		 	<label> 1. 분류 : </label> 
		    <select name = "bookType" id="bookType" size = "1" > 
		        <option value = "${requestScope.dto.bookType}">${requestScope.dto.bookType}</option>
		      	<option value = "소설"> 소설 </option>
		      	<!-- 		
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
	    		 -->
	    	</select>
		</div><br>
	  
	  
		<div class="postInfo"> 
		  	<label> 2. 취향 : </label> 
		    <select name = "favorite" size = "1"> 
		    	<option value = "${requestScope.dto.favorite }">${requestScope.dto.favorite }</option>
	      		<option value = "달달한 로맨스"> 달달한 로맨스 </option>
	   	   		<option value = "유쾌한 코미디"> 유쾌한 코미디 </option>
	      		<option value = "짜릿한 무협/액션"> 짜릿한 무협/액션 </option>
	      		<option value = "뇌섹남의 공포/추리"> 뇌섹남의 공포/추리 </option>
	      		<option value = "화려한 판타지/SF"> 화려한 판타지/SF </option>
	    	</select>      
		</div><br>
	  
		<div class="postInfo"> 
	  		<label> 3. 난이도 : </label> 
	    	<select name = "bookLevel" size = "1">
	    		<option value = "${requestScope.dto.bookLevel }">${requestScope.dto.bookLevel }</option>
	     	 	<option value = "상"> 상 </option> 
	      		<option value = "중"> 중 </option>
	      		<option value = "하"> 하 </option>
	    	</select>  
	    
	    <p>* 도서별로 지정된 분류/취향/난이도에 따라 선택해주세요</p>
	    
		</div>
		<hr>
	
		<h3>추천 점수를 입력해주세요^-^</h3>
	
		<div class="postInfo">
			<input type="number" name="score" id="score" min="1" max="10" value="${requestScope.dto.score }">
			<p>[비추천] 1  <------> 10 [추천]</p>
		</div><br>
		
		<div align="center"><input type="submit" name="postBtn" value="게시글 수정"></div><br>
	
	
	</form>
	
  </section>
 
 	
 
  <!-- web page loading 시 초기화 로직 -->
  <script src="initPost.js"></script>


  <!-- 게시글 정보 필터링-->
  <script src="postValidation.js"></script>

</body>

</html>