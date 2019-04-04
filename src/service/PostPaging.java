package service;

public class PostPaging {

	public PostPaging() {}
	
	
	
	// web page에 출력하는 page 번호 // 
	// One web page = Ten post
	public int[] countPage(int totalCount) {
		
		int[] resultArr = new int[4];
		
		
		int startPage = 0;
		int endPage = 0;
		int totalPage = 0;				// 전체 페이지 수 (=페이지 번호) 
		int countList = 10; 			// 한 페이지에 출력될 게시글 수 (max 10)
		int countPage = 10;				// 한 페이지에 출력될 page 번호 (max 10)
		
		// test
		int page = 1;					// 현재 page
										// 추후 client에서 parameter로 전달받아야함
		
		
		// 전체 페이지 수를 구하는 logic //
		
		totalPage = totalCount / countList;
		
		if(totalCount % countList > 0) {		// 마지막 페이지의 게시글이 not full
			totalPage++;
		}
		
		
		// start/end page logic //  
		startPage = ((page-1)/10) * 10 +1;
		endPage = startPage + countPage - 1;
		
		// 마지막 페이지 수 보정
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		
		// test
		resultArr[0] = startPage;
		resultArr[1] = endPage;
		
		return resultArr;
		
		
	} // countPage() END
	
	
	
	// test
	////////// 검증이 필요한 로직
	// 게시글 시작 번호(startNum)와 게시글 수(countList)를 연산
	public int[] searchPost(int pageNum, int totalCount) {
		
		int[] searchInfo  = new int[2];
		
		int countList = 10;
		int startNum = 0;
		
		// 클릭한 page번호가 마지막 번호인 경우 countList 셋팅
		if(totalCount%(5*(pageNum-1)) > 0) {
			countList = totalCount % ( 5*(pageNum-1) ) ;
		}
		
		startNum = totalCount - (5 * (pageNum-1));
		
		searchInfo[0] = countList;
		searchInfo[1] = startNum;
		
		return searchInfo;	
		// 이 값을 가지고 DB postInfo table에 저장된 해당 page의 게시글리스트를 조회
		
		
		
	}// searchPost() END
	
	
	
	
	// test
	public void pageNumber() {

		int totalCount = 25;		// 전체 게시글 수 : table에서 전체 record수 조회

		int totalPage = 0;			// 전체 페이지 수 (=페이지 번호) 

		int countList = 0; 		// 한 페이지에 출력될 게시글 수 (max 10) 

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
