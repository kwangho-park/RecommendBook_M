package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import dao.UserInfoDao_old;
import dto.UserInfoDto;
import dto.UserInfoDto_old;

public class SignUpFilterCommand implements Command{
	 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boolean result = false;
		
		String id 		= request.getParameter("id");
		String pw 		= request.getParameter("pw");
		String name 	= request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String email01 	= request.getParameter("email01");
		
		String email02 	= request.getParameter("email02");						////// 데이터가 안넘어옴 
		int postCode	= Integer.parseInt(request.getParameter("postCode"));		// int -> String 
		String roadAddress 	= request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		
		
		// 회원가입을 위한 setting // 
		UserInfoDto userInfoDto = new UserInfoDto(id, pw, name, birthday, email01, email02, postCode, roadAddress, jibunAddress, detailAddress, extraAddress);
		UserInfoDao dao = new UserInfoDao();
		
		
		// id 중복조회 및 회원 가입 // 
		if(!dao.filter(id)) {				// id 중복조회
			dao.insert(userInfoDto);		
			result = true;
		}
		
		
		// browser 경고창 출력을 위한 setting
		request.setAttribute("signUpFilterResult", result);

		
	} // execute() END

} // singUpFilterCommand END
