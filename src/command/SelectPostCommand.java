package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostInfoDao;
import dto.PostInfoDto;
import service.PostPaging;

public class SelectPostCommand implements Command{
  
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		PostInfoDao postInfoDao = new PostInfoDao();
		
		PostPaging postPaging;
	 
		int[] searchInfo = new int[6];	


		// DB에서 post를 검색하기 위한 resource//
		
		int totalCount = 0;
		
		int pageNum = 0;
		
		String initPageNum = "";
		
		
		
		
		// post를 출력하기 위한 자원 얻기 //
		// client : pagaNum, DB : totalCount
		
		initPageNum = request.getParameter("pageNum");
		
		totalCount= postInfoDao.selectTotalCount();
		
		
		// 초기 recommendBook page 로드 시 parameter가 없는것을 보완
		// [장기적 고민] 코드 가독성을 위해 contoller에서 뺴야할듯...
		if(initPageNum == null) {		
			pageNum = 1;
			
		}else {
			pageNum = Integer.parseInt(initPageNum);			
		}
	
		
		// PostPaging initialization //
		postPaging = new PostPaging(pageNum, totalCount);
		
		
		
		// page에 출력 할 post setting // 
		
		searchInfo = postPaging.searchPost();

		ArrayList<PostInfoDto> postList = postInfoDao.selectPage(searchInfo);		
		
		request.setAttribute("postList", postList);

		
		// countPage 연산 및 셋팅 //
		// [추후 업데이트] array ->  hashMap 변환 (set data structure) - 이유 : index는 가독성이 매우 나쁨
		int[] countPage = postPaging.countPage();
		
		request.setAttribute("countPage", countPage);
		
		
		
		
		
	} // execute() END
	
}// SelectPostCommand END
