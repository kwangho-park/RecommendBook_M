/**
 * 다음 우편번호 서비스(open API) 를 이용한 javascript
 * URL : https://spi.maps.daum.net/postcode/guidessl#attributes
 */


 


function execDaumPostcode() {
	

	// 객체 생성자 함수 daum.Postcode({....}).open();
	
	new daum.Postcode({
		
		// 팝업창에서 특정항목 클릭 시 동작 //
		oncomplete: function(data) { 		// data = 사용자가 선택한 주소를 저장한 객체(=참조변수)
			
			// 우편번호, 도로명주소, 지번주소 setting  //
            document.getElementById('postCode').value = data.zonecode;		
            document.getElementById("roadAddress").value = data.roadAddress;	
            document.getElementById("jibunAddress").value = data.jibunAddress;	
            
            
            var roadAddr = data.roadAddress; // 도로명 주소 data
            var extraRoadAddr = ''; 		// 참고 항목 data

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            

            // 참고항목 setting // 
            if(roadAddr !== ''){
                document.getElementById("extraAddress").value = extraRoadAddr;
                
            } else {
                document.getElementById("extraAddress").value = '';
            }
        }
    }).open();
}
