package service;

public class PostPaging {

	public PostPaging() {}
	

	// countPage를 셋팅하기 위한 resource : start/end page // 
	public int[] countPage(int pageNum, int totalCount) {
		
		int[] resultArr = new int[4];
		
		
		int startPage = 0;
		int endPage = 0;
		int totalPage = 0;				// 전체 페이지 수 (=페이지 번호) 
		int countList = 10; 			// 한 페이지에 출력될 게시글 수
		int countPage = 10;				// 한 페이지에 출력될 page 번호
		
		int pageGroup = 0;				// countPage의 그룹 (countPage * 10(max) = 1group)
		
		final int limitList = 10;
		final int limitPage = 10;				
		
		
		// 전체 페이지 수를 구하는 logic //
		
		totalPage = totalCount / countList;
		
		if(totalCount % countList > 0) {		// 마지막 페이지의 게시글이 not full
			totalPage++;
		}
		
		
		// start/end page logic //  
		/*
		startPage = ((pageNum-1)/10) * 10 +1;
		endPage = startPage + countPage - 1;
		*/
		
		if(pageNum<=10) {
			startPage = 1;
			endPage = 10;
			
		}else if((pageNum>10) && (pageNum<=20)){
			startPage = 11;
			endPage = 20;
			
		}else if((pageNum>20) && (pageNum<=30)) {
			startPage = 21;
			endPage = 30;			// 추후 totalPage로 변경예정
		}
		
		pageGroup = (totalPage / 10) + 1;
		

		
		// 마지막 페이지 수 보정
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		
		// test
		resultArr[0] = startPage;
		resultArr[1] = endPage;
		
		return resultArr;
		
		
	} // countPage() END
	
	
	
	// 클릭한 page의 게시글을 탐색하기위한 logic // 
	public int[] searchPost(int pageNum, int totalCount) {
		
		int[] searchInfo  = new int[2];
		
		int countList = 10;					// 게시글 수
		int startRowNum = 0;				// 게시글 시작 번호 (출력해야하는 게시글의 오름차순 정렬 시 가장상단의 row번호 )
		
		
		if(pageNum != 1) {
			startRowNum = (pageNum - 1) * 10;
		}

		
		// 마지막 pageNum 일 때 츨력하는 게시글수 조정
		if(pageNum == (totalCount / 10) + 1) {		 
			countList = totalCount % 10;
		}
	
				
		
		searchInfo[0] = startRowNum;
		searchInfo[1] = countList;

		
		return searchInfo;	
		
	}// searchPost() END
	
	
	
	
	// test
	public void pageNumber() {

		int totalCount = 25;		// 전체 게시글 수 : table에서 전체 record수 조회

		int totalPage = 0;			// 전체 페이지 수 (=페이지 번호) 

		int countList = 0; 			// 한 페이지에 출력될 게시글 수 (max 10) 

		int countPage = 0;			// 한 화면에 출력될 페이지 수 (max 10)

		int page = 0;				// 현재 페이지 : client로부터 전달받아야함
		
		int startPage = 0;
		int endPage = 0;
		
	
		
		if(startPage > 1) {
			System.out.println("처음");
		}
		
		if(page > 1) {
			System.out.println("이전");
		}
		
		// 글자 굵기 //
		for(int iCount = startPage ; iCount<= endPage ; iCount++) {
			
			if(iCount == page) {
				System.out.println("굵게 표기"+iCount);
			}else {
				System.out.println("보통 표기"+iCount);
			}
		}
		
		
		if(page < totalPage) {
			System.out.println("다음"+ (page + 1));
		}
		
		if(endPage < totalPage) {
			System.out.println("끝" + totalPage);
		}
		
	} //pageNumber() END
	
	
}// PostPaging END
