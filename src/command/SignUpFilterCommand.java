package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import dto.UserInfoDto;

public class SignUpFilterCommand implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boolean result = false;
		
		String id 		= request.getParameter("signUpId");
		int pw 			= Integer.parseInt(request.getParameter("signUpPw"));
		String name 	= request.getParameter("signUpName");
		String brathday = request.getParameter("signUpBrathday");
		String email 	= request.getParameter("signUpEmail");
		String address 	= request.getParameter("signUpAddress");
		String process 	= request.getParameter("signUpProcess");
		String advertising = request.getParameter("signUpAdvertising");
		
		UserInfoDto userInfoDto = new UserInfoDto(id, pw, name, brathday, email, address, process, advertising);
		UserInfoDao dao = new UserInfoDao();
		
		
		if(!dao.filter(id)) {				// id 중복조회
			dao.insert(userInfoDto);		// debugging
			result = true;
		}
		
		
		// browser 경고창 출력을 위한 setting
		request.setAttribute("signUpFilterResult", result);

		
	} // execute() END

} // singUpFilterCommand END
