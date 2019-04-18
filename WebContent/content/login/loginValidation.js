/*
 * 로그인 유효성 검사 로직
 *
 * */



/* login button click 시 실행되는 함수 */
function login() {

	var result = false;
	
	/* <input> tage의 dom객체의 data를 셋팅 */
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;

	/* login 유효성검사을 위한 instance 생성 및 초기화 */
	var loginValidation = createValidation(id, pw);

	// 로그인 정보 유효성 검사 //
	if (loginValidation.validation()) {		

		result = true;

		// set loginFlag //
		sessionStorage.setItem("loginFlag",id);
	}

	
	return result;
	
} // login() END



/* 로그인정보(id,pw) validation(유효성) function */

function createValidation(id, pw) {

	// filter을 위한 객체 정의
	return {
		validation : function() {

			var result = false;

			if ((id != "") && isNaN(id)) { // isNaN : is + Not a Number :
											// 문자열일경우 true
				if (pw != "") {
					result = true;
				} else {
					alert("PW를 입력하세요");
				}
			} else {
				alert("ID를 문자로 입력하세요");
			}
			return result;
		}
	} // object END
} // createValidation() END


