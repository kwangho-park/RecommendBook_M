
/* 회원가입 정보의 유효성(JS) 및 중복검사(JSP)  로직 */

/* 유효성 검사 정의(임시) */
/*
id = 문자열
password = 숫자
name = 문자열
email = 이메일 형식 (정규식 활용)   - 미구현 2018.12.03
address = 문자열
 */


/* '회원가입신청' submit click 시 실행되는 함수 */
// 회원가입 양식의 유효성 검사
function signUpValidation() {
	
	/* <input> 의 dom객체의 참조값을 반환 */
	var idDom = document.getElementById("id");
	var pwDom = document.getElementById("pw");
	var nameDom = document.getElementById("name");
	var brathdayDom = document.getElementById("brathday"); // 사용자 입력 시 <input>
															// attribute(date)에서
															// 필터링
	
	var emailDom = document.getElementById("email"); // 필터링 적용 필요
	var addressDom = document.getElementById("address");

	/* [??] 이메일의 유효성을 검사하는 정규식 */
	// 정규식에 대해 공부한 이후 진행
	// var resultEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	// var resultEmail =
	// /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;


	/* 객체 생성 및 참조값 할당 */
	// 사용자에게 입력받은 data를 filter method에게 전달 (은닉된 creaeFilter 변수를 setting)
	var login = createValidation(idDom.value, pwDom.value, nameDom.value, brathdayDom.value);


	/* 회원가입정보의 유효성을 검사하는 함수 호출(=즉, 실행) */ 
	return login.validation();
	
	

} // signUpValidation() END




// 유효성 검사 : Validation Check
/* 회원가입 정보의 유효성검사 function */
// id, pw, name, brathday
function createValidation(id, pw, name, brathday) {

	return {
		validation : function() { // filter property의 closure method???

			var result = false;
			
			// 회원정보 filtering 알고리즘
			// isNaN 라이브러리 메소드 : not a number : 숫자가 아닐경우 true반환
			if ((id != "") && (isNaN(id))) {		 	// id : 공백과 숫자일경우 실행x

				if ((pw != "") && (!isNaN(pw))) { 		// pw : 공백과 문자일경우 실행x
					if ((name != "") && (isNaN(name))) {// name : 공백과 숫자일경우
														// 실행x
						if (brathday != "") { 			// brathday : 공백일경우 실행x
							

							result = true;
							alert("유효성검사 통과")
							
							
						} else {alert("생년월일을 입력해주실래요??^^");}
					} else {alert("이름을 문자로 입력해주실래요??^^");}
				} else {alert("pw을 숫자로 입력해주실래요??^^");}
			} else {alert("id를 문자로 입력해주실래요?^^");}
			
			return result;
			
		} // filter() END
	} // return object END
} // createFilter() END



