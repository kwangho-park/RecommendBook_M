
<%--사용자의 로그인정보(loginId, loginPw)를 필터링하는 로직--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="memberDB" class="old.clientInfo.MemberDB" scope="application"/>


<jsp:setProperty name="memberDB" property="*"/>


<c:choose>

	<c:when test="${applicationScope.memberDB.loginFilter()}">
		<script>alert("로그인 성공! nice job!")</script>
		<script>location.href="/RecommendBook_M/content/recommendBook/recommendBook.jsp"</script>
	</c:when>

	<c:otherwise>
		<script>alert("아이디 또는 비밀번호가 일치하지 않습니다! please, one more!")</script>
		<script>location.href="/RecommendBook_M/content/login/login.jsp"</script>	
	</c:otherwise>
	
</c:choose>
