package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signUpFilterCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String signUpId 		= request.getParameter("signUpId");
		int signUpPw 			= Integer.parseInt(request.getParameter("signUpPw"));
		String signUpName 		= request.getParameter("signUpName");
		String signUpBrathday 	= request.getParameter("signUpBrathday");
		String signUpEmail 		= request.getParameter("signUpEmail");
		String signUpAddress 	= request.getParameter("signUpAddress");
		String signUpProcess 	= request.getParameter("signUpProcess");
		String signUpAdvertising = request.getParameter("signUpAdvertising");
		
		
		// dto, dao, signUpFilter 객체 생성
		
		// dao 객체 실행 및 dto전달
		
		// signUpFilter 객체에 dto넘겨주기
		// 필터링 결과값반환
		
		
		// 필터링 결과 값을 토대로 흐름제어
		// true = 개인정보를 저장하는 dao 실행
		// false = x 
		
		
	} // execute() END

} // singUpFilterCommand END
