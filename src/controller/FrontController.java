
package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.DeletePostCommand;
import command.LoginFilterCommand;
import command.ModifyPostCommand;
import command.SavePostCommand;
import command.SearchBookCommand;
import command.SelectPostCommand;
import command.SignUpFilterCommand;
import command.ViewPostCommand;

// 서브렛 표기용 do

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	
	 
	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException{
		System.out.println("execute init");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("execute doGet");
		actionDo(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("execute doPost");
		actionDo(request, response);

	}
	
	
	
	// view, model로 가기위한 통로의 역활 //
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		System.out.println("execute actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		
		String viewPage = null;
		Command command = null;
		
		
		// 분배를위한 파일경로 찾기 //
		// [추후] 개선이 필요한 부분
		String uri = request.getRequestURI();				// context path + 요청 파일경로 반환 
		String conPath = request.getContextPath();			// context path 반환	
		String com = uri.substring(conPath.length());		// 요청 파일 path 반환


		// 사용자가 입력한 URL의 경로를 분배하고 실행하는 로직 // 	
		// [menu] index page 요청
		if(com.equals("/content/index/index.do")) {						
			viewPage = "/content/index/index.jsp";
			
			
		// [menu] login page 요청
		}else if(com.equals("/content/login/login.do")){				
			viewPage = "/content/login/login.jsp";

		// [menu] logout page 요청
		}else if(com.equals("/content/logout/logout.do")){

			viewPage = "/content/logout/logout.jsp";
						
			
		// [menu] signUp page 요청	
		}else if(com.equals("/content/signUp/signUp.do")) {
			viewPage = "/content/signUp/signUp.jsp";

			
		// [menu] post page 요청
		}else if(com.equals("/content/post/post.do")) {
			viewPage = "/content/post/post.jsp";

		// [menu] recommendBook page 요청
		}else if(com.equals("/content/recommendBook/recommendBook.do")){
			
			// print ALL post
			command = new SelectPostCommand();
			command.execute(request, response);
			
			viewPage = "/content/recommendBook/recommendBook.jsp";
			
	
		// login 실행
		}else if(com.equals("/content/login/loginFilter.do")) {										
			
			// db table에서 id와 pw를 비교
			command = new LoginFilterCommand();
			command.execute(request, response);

			// db 에서 데이터를 비교한 결과에 따라 if문으로 분배
			if((boolean) request.getAttribute("loginFilterFlag")) {
				viewPage = "/content/recommendBook/recommendBook.do";
			}else {
				viewPage = "/content/login/login.jsp";
			}
			
					
		// signUp 실행 
		}else if(com.equals("/content/signUp/signUpFilter.do")) {
			
			command = new SignUpFilterCommand();
			command.execute(request, response);
			
			viewPage = "/content/signUp/signUp.jsp";			
		
			
		// save post + print All post
		}else if(com.equals("/content/post/savePost.do")) {

			command = new SavePostCommand();
			command.execute(request, response);
			
			// print ALL post
			command = new SelectPostCommand();
			command.execute(request, response);
			
			
			viewPage = "/content/recommendBook/recommendBook.do";
		
		// 특정(=num) post 조회
		}else if(com.equals("/content/post/viewPost.do")) {
			
			command = new ViewPostCommand();
			command.execute(request, response);
			
			viewPage = "/content/post/viewPost.jsp";
			
			
		// post 수정	
		}else if(com.equals("/content/post/modifyPost.do")){
			
			command = new ModifyPostCommand();
			command.execute(request, response);
			
			viewPage = "/content/recommendBook/recommendBook.do";
			
			
		// 특정(=num) post 삭제	
		}else if(com.equals("/content/post/deletePost.do")) {
		
			// 특정 post 삭제하는 command
			command = new DeletePostCommand();
			command.execute(request, response);
	
			viewPage = "/content/recommendBook/recommendBook.do";
		
				
		// 도서 추천검색					   
		}else if(com.equals("/content/recommendBook/searchBook.do")) {	
			
			
			// search post
			command = new SearchBookCommand();
			command.execute(request, response);
			
			// print ALL post
			command = new SelectPostCommand();
			command.execute(request, response);
						
			
			viewPage = "/content/recommendBook/recommendBook.jsp";	
		}
		
	
		// forwarding // 
		// 분배된 결과 페이지를 출력하기위한 forwarding (view 단에서 <jsp:forward /> 와 동일한 역활
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	
	}
	

	public void destroy() {
		System.out.println("execute destroy");
	}
	
}  // Controller END
