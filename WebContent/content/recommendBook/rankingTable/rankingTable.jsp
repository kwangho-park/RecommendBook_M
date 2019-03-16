<!-- search book의 inline frame 2 -->

<!-- page directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title> book ranking </title>
  
  <meta charset = "utf-8">
  <meta name="description" 	content = "사용자의 취향을 고려한 도서 추천 웹 사이트">
  <meta name="keywords" 	content = "book">
  
  <!-- 전체 영역 단위 CSS -->
  <link href="/RecommendBook_M/content/common/webSiteStyle.css" type="text/css" rel="stylesheet">
  
  <!-- 해당 페이지 단위 CSS -->
  <link href="rankingTable.css" type="text/css" rel="stylesheet">
  
  
  
</head>


<body>
	
  
   <h2>추천 순위</h2>
   
   <div class="rankingTable">
 
  
   
   <table>
     <caption>추천 순위표</caption>
     
     <thead>
     <tr><th>순위</th><th>도 서 명</th> <th>작 가 명</th> <th>추천 점수(평균)</th></tr> 
     </thead>

     <tbody>
     <tr><td>1</td><td><a href="/RecommendBook_M/content/reference/commentBook/book1.html" target="_blank">백야행					</a></td><td>히가시노 게이고</td> <td>10</td> </tr>
     <tr><td>2</td><td><a href="/RecommendBook_M/content/reference/commentBook/book2.html" target="_blank">용의자 x의 헌신			</a></td><td>히가시노 게이고</td> <td>8</td> </tr>
     <tr><td>3</td><td><a href="/RecommendBook_M/content/reference/commentBook/book3.html" target="_blank">밀실살인게임			</a></td><td>우타노 쇼고</td> <td>7</td> </tr>
     <tr><td>4</td><td><a href="/RecommendBook_M/content/reference/commentBook/book4.html" target="_blank">설민석의 조선왕조실록	</a></td><td>설민석</td> <td>6</td> </tr>
     <tr><td>5</td><td><a href="/RecommendBook_M/content/reference/commentBook/book5.html" target="_blank">만년대리 양대리의 본색	</a></td><td>고지영</td> <td>4</td> </tr>
     </tbody>
   
   </table>
    
   </div>

</body>
</html>