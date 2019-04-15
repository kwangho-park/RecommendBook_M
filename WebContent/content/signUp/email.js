


$('#selectEmail').change(function(){
	$("#selectEmail option:selected").each(function () {
		
		if($(this).val()== '1'){ 	//직접입력일 경우 
			
			$("#email02").val(''); 
			$("#email02").attr("disabled",false); 			//활성화 
			
		}else{ 						//직접입력이 아닐경우 

			$("#email02").val($(this).text()); 				//선택값 입력 
			$("#email02").attr("disabled",true); 			//비활성화 
		}
	}); 
});


