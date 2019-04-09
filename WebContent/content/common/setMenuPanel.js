
// DOM 객체 로딩 후 실행되는 jQuery method
$(function(){
		
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
	    
	   
	   	
    loginFlag = getCookie("loginFlag");
	   
    // [debug] login.jsp 실행시 flag가 true인 이유는?
    // getCookie() 동작 방식을 분석해야함
    if(loginFlag==="true"){		// 로그인
	    	
    	$(".menuPanel > #login").attr("href","/RecommendBook_M/content/logout/logout.do").text("로그아웃");
  
    }else if((loginFlag===null) || (loginFlag ==="false")){	// 로그아웃
	    	
    	$(".menuPanel > #login").attr("href","/RecommendBook_M/content/login/login.do").text("로그인");
    }
    
    // test
    // alert(loginFlag);
	    
}); // function() END
	  