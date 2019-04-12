package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchPostInfoDao;
import dto.PostInfoDto;

public class SearchBookCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String bookType = request.getParameter("bookType");
		String favorite = request.getParameter("favorite");
		String bookLevel = request.getParameter("bookLevel");
		
		SearchPostInfoDao postInfoSearchDao = new SearchPostInfoDao();
		
		ArrayList<PostInfoDto> searchList = new ArrayList<PostInfoDto>();
		
		
		
		searchList = postInfoSearchDao.SearchPost(bookType, favorite, bookLevel);
		
		request.setAttribute("searchList", searchList);
		
	}
	
}//  SearchBookCommand END
