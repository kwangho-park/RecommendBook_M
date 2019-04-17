


$('#selectEmail').change(function(){						// change() = event handler 와 JS event를 바인딩(bind), 인자 : call back function
	$("#selectEmail option:selected").each(function () {	// ????
		
		if($(this).val()== '1'){ 	//직접입력일 경우 
			
			$("#email02").val(''); 
			
		}else{ 						//직접입력이 아닐경우 

			$("#email02").val($(this).text()); 				//선택값 입력 
		}
	}); 
});


