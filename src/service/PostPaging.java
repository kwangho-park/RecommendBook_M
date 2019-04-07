package service;

public class PostPaging {

	public PostPaging() {}
	
	private int pageNum = 0;
	private int totalCount = 0;
	
	public PostPaging(int pageNum, int totalCount) {
		this.pageNum = pageNum;
		this.totalCount = totalCount;
	}
	

	// countPage를 셋팅하기 위한 연산 // 
	// start/end + before/after + begin/finish
	public int[] countPage() {
		
		// [추후 업데이트] array ->  hashMap 변환 (set data structure) - 이유 : index는 가독성이 매우 나쁨
		int[] pageInfo = new int[6];
		
		int startPage = 0;
		int endPage = 0;
		
		int beforePage = 0;
		int afterPage = 0;
		int beginPage = 0;
		int finishPage = 0;
		
		int totalPage = 0;				// 전체 페이지 수 (=페이지 번호) 
		int countList = 10; 			// 한 페이지에 출력될 게시글 수
		int countPage = 10;				// 한 페이지에 출력될 page 번호
		
		
		// 전체 페이지 수를 구하는 logic //
		
		totalPage = this.totalCount / countList;
		
		if(this.totalCount % countList > 0) {		// 마지막 페이지의 게시글이 not full
			totalPage++;
		}
		
		
		// start/end page logic //  
		
		startPage = ((this.pageNum-1)/10) * 10 +1;		// (pageNum-1)/10 연산결과 1~10 = 1, 11~20 = 2... 
		endPage = startPage + countPage - 1;

		// 마지막 페이지 수 보정
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		
		
		// before/after,  begin/finish page logic //
		if(pageNum == 1) {
			beforePage = 1;
		}else {
			beforePage = this.pageNum - 1;	
		}
		
		if(pageNum == endPage) {
			afterPage = endPage;
		}else {
			afterPage = this.pageNum + 1;
		}
		
		beginPage = 1;
		finishPage = totalPage;
		
	
		pageInfo[0] = startPage;
		pageInfo[1] = endPage;
		pageInfo[2] = beforePage;
		pageInfo[3] = afterPage;
		pageInfo[4] = beginPage;
		pageInfo[5] = finishPage;
				
		return pageInfo;
		
		
	} // countPage() END
	
	
	 
	
	// DB 게시글 탐색시 필요한 자원을 연산 //
	public int[] searchPost() {
		
		int[] searchInfo  = new int[2];
		
		int countList = 10;					// 게시글 수
		int startRowNum = 0;				// 게시글 시작 번호 (출력해야하는 게시글의 오름차순 정렬 시 가장상단의 row번호 )
		
		
		if(this.pageNum != 1) {
			startRowNum = (this.pageNum - 1) * 10;
		}

		
		// 마지막 pageNum 일 때 츨력하는 게시글수 조정
		if(this.pageNum == (this.totalCount / 10) + 1) {		 
			countList = this.totalCount % 10;
		}
	
				
		
		searchInfo[0] = startRowNum;
		searchInfo[1] = countList;

		
		return searchInfo;	
		
	}// searchPost() END
	
	
}// PostPaging END
