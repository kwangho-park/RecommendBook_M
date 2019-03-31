

function setLoginFlag(){
	

    // [장기적 고민] 
  	// Cookie에 저장된 값을 조회
  	// server에서 보내준 cookie값과 client에 저장된 값을 조회??
  	var getCookie = function(name){
        var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
        return value? value[2] : null;
    };
	
    var setCookie = function(name, value, day) {
        var date = new Date();
        date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
        document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    };

    var deleteCookie = function(name) {
        var date = new Date();
        document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/";
    }

	
	setCookie("loginFlag",true, 1);		// 1일동안 cookie data저장
	
	
}// setLoginFlag() END