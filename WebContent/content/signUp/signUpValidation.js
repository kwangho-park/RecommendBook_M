
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
// jQuery로 업데이트 예정
function signUpValidation() {

	/* <input> 의 dom객체의 참조값을 반환 */
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	var name = document.getElementById("name").value;
	var birthday = document.getElementById("birthday").value; 
	
	var email01 = document.getElementById("email01").value;
	var email02 = document.getElementById("email02").value;
	
	var postCode = document.getElementById("postCode").value;
	var roadAddress = document.getElementById("roadAddress").value;
	var jibunAddress = document.getElementById("jibunAddress").value;
	

	

	/* 객체 생성 및 참조값 할당 */
	// 사용자에게 입력받은 data를 filter method에게 전달 (은닉된 creaeFilter 변수를 setting)
	///////// 에러발생
	var login = createValidation(id, pw, name, birthday, email01, email02, postCode, roadAddress, jibunAddress);


	/* 회원가입정보의 유효성을 검사하는 함수 호출(=즉, 실행) */ 
	return login.validation();
	
	

} // signUpValidation() END




// 유효성 검사 : Validation Check
/* 회원가입 정보의 유효성검사 function */
function createValidation(id, pw, name, birthday, email01, email02, postCode, roadAddress, jibunAddress) {

	return {
		validation : function() {

			var result = false;
			
			// 회원정보 filtering // 
			// isNaN 라이브러리 메소드 : not a number : 숫자가 아닐경우 true반환
			if ((id != "") && (isNaN(id))) {
				if (pw != "") { 		
					if ((name != "") && (isNaN(name))) {
						if (birthday != "") { 			
							if((email01 !="") && (email02 !="") &&(isNaN(email01)) &&(isNaN(email02))){
								if((postCode !="") && (roadAddress !="") && (jibunAddress !="") ){

									result = true;
									
								}else {alert("주소를 입력해주세요");}		
							}else{alert("이메일을 입력해주세요");}
						} else {alert("생년월일을 입력해주세요");}
					} else {alert("이름을 문자로 입력해주세요");}
				} else {alert("pw을 입력해주세요");}
			} else {alert("id를 문자로 입력해주세요");}
			
			return result;
			
		} // filter() END
	} // return object END
} // createFilter() END



