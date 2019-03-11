<%-- 사용자가 입력한 정보와  (임시) DB의 데이터를 비교 --%>
<%-- 최대저장공간 및 id 중복 여부--%>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="memberDB" class="old.clientInfo.MemberDB" scope="application"/>

<%
	request.setCharacterEncoding("UTF-8");
%>


<hr>

<%-- id 필터링을 위한 memberDB instance에 id setting --%>
<jsp:setProperty name="memberDB" property="signUpId" value="${param.signUpId }"/>
		
		
			
<%-- 회원정보 filtering 로직 --%>
<c:choose>
	<c:when test="${!applicationScope.memberDB.isFull()}">
		<c:choose>

			<c:when test="${applicationScope.memberDB.idFilter()}">

				<jsp:setProperty name="memberDB" property="*"/>

				${applicationScope.memberDB.setMemberArr() }

				<script>alert("드디어 회원가입이 완료되었습니다! good job!")</script>
				<script>location.href="/RecommendBook_M/content/login/login.jsp"</script>

			</c:when>

			<c:otherwise>
				<script>alert("중복된 아이디가 존재합니다! please, one more!")</script>
				<script>location.href="/RecommendBook_M/content/signUp/signUp.jsp"</script>
			</c:otherwise>
		</c:choose>
	</c:when>
	
	<c:otherwise>
		<script>alert("데이터베이스에 저장 가능한 공간이 없습니다! I'm sorry!")</script>
		<script>location.href="/RecommendBook_M/content/signUp/signUp.jsp"</script>
	</c:otherwise>
</c:choose>
