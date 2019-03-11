/*
 * 로그인 유효성 검사 로직
 * 저장소 : session storage (client side) -> application (server side)
 * 
 * */



/* login button click 시 실행되는 함수 */
function login() {

	var result = false;
	
	/* <input> tage의 dom객체의 참조값을 셋팅 */
	var idDom = document.getElementById("id");
	var pwDom = document.getElementById("pw");

	/* login 유효성검사을 위한 instance 생성 및 초기화 */
	var loginValidation = createValidation(idDom.value, pwDom.value);


	// 로그인 정보 유효성 검사 //
	if (loginValidation.validation()) {		

		alert("[유효성 검사 통과]")
		result = true;
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
				if (pw != "" && !isNaN(pw)) {
					result = true;
				} else {
					alert("[유효성검사 실패] PW를 숫자로 입력하세요");
				}
			} else {
				alert("[유효성검사 실패] ID를 문자로 입력하세요!!");
			}
			return result;
		}
	} // object END
} // createValidation() END




// 미사용...old //
/* web server or DB로 송신을 위한 DTO */
// 실제로 사용하는지는 미지수.... 일단은 closure 연습용!
function createDTO(id, pw) {

	var clientNumber = 1; // 외부 function variable 적용응

	return {
		// geter //
		getId : function() {
			return id;
		},
		getPw : function() {
			return pw;
		},

		// setter //
		setId : function(_id) {
			id = _id;
		},
		setPw : function(_pw) {
			pw = _pw;
		},

		num : clientNumber
	} // object END
}// createDTO() END
