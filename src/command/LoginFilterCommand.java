package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import dto.UserInfoDto;
import service.LoginFilter;

public class LoginFilterCommand implements Command{
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 사용자가 입력한 id, pw //
		String loginId = request.getParameter("loginId");
		int loginPw = Integer.parseInt(request.getParameter("loginPw"));

		
		// service 객체, DAO 객체 //
		UserInfoDao dao = new UserInfoDao();
		LoginFilter loginFilter =  new LoginFilter();
		
		
		ArrayList<UserInfoDto> dto = null;
		boolean result = false;
		
	
		
		// DAO 에서 id, pw 조회하는 로직 실행
		dto = dao.select();
		
		
		// service 에서 id, pw 비교하는 로직 setting 및 execute	
		loginFilter.setInputId(loginId);
		loginFilter.setInputPw(loginPw);
		loginFilter.setDto(dto);
		
		result = loginFilter.filter();		// true or false
		
		// browser 경고창 출력을 위한 setting
		request.setAttribute("loginFilterResult", result);

		
		
	} // execute() END


} // LoginCommand END
