
/* logout 버튼 클릭시 동작하는 logic*/

var deleteCookie = function(name) {
      var date = new Date();
      document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/";
}

   
function logoutBtn(){
	 
 
  var input = confirm("로그아웃 하시겠습니까?");
                
  if(input){
	  
	deleteCookie("loginFlag");
  	location.href = "/RecommendBook_M/content/login/login.do";
    
  	alert("로그아웃 되었습니다")
	  
  }else{
	alert("로그아웃이 취소 되었습니다")
  }
}// logoutBtn