package command;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
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

		Cookie loginFlag = null;
		String strFlag ="";
		boolean flag = false;
		
	
		
		// DAO 에서 id, pw 조회하는 로직 실행
		dto = dao.select();
		
		
		// service 에서 id, pw 비교하는 로직 setting 및 execute	
		loginFilter.setInputId(loginId);
		loginFilter.setInputPw(loginPw);
		loginFilter.setDto(dto);
		
		flag = loginFilter.filter();		// true or false
		
		request.setAttribute("loginFilterFlag", flag);	// JSP에서 사용하기위해 request영역에 추가
		
		
		
		
		// 로그인 flag setting //
		// [장기적 고민] try catch를 하지않으면 response setting 시 에러발생 = 이유는???
		
		strFlag = Boolean.toString(flag);
		
		try {
			loginFlag = new Cookie("loginFlag", URLEncoder.encode(strFlag,"UTF-8"));
			response.addCookie(loginFlag);				// web browser에 전송하기위해 response 영역에 추가
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		

	} // execute() END
} // LoginCommand END
