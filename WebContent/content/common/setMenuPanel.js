
// DOM 객체 로딩 후 실행되는 jQuery method
$(function(){
/*		
    // [장기적 고민] 
  	// login page에서 loginFlag가 true값으로 고정되는 현상발생
	// 서버,클라이언트 측에서 셋팅해도 변경되지않음 -> session storage로 변경
	// cookie 제어를 위해 필요한 function //
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
	    
*/   

	
	
	var loginFlag = sessionStorage.getItem("loginFlag"); 
	
	
	
    if(loginFlag==null){	// logout 상태 
    	
    	$(".menuPanel > #login").attr("href","/RecommendBook_M/content/login/login.do").text("로그인");
    	
    	// link 비활성
    	$(".menuPanel > #recommendBook").bind('click', false);
    	$(".menuPanel > #post").bind('click', false);    	

    }else{				// login 상태

    	$(".menuPanel > #login").attr("href","/RecommendBook_M/content/logout/logout.do").text("로그아웃");
    	
    	// link 활성
    	$(".menuPanel > #recommendBook").unbind('click', false);
    	$(".menuPanel > #post").unbind('click', false);
    	
    }
    
    // test
    // console.log("loginFlag 조건값 : "+sessionStorage.getItem("loginFlag"));
    
  

}); // function() END
	  