/*
 * (임시) data base
 * PostInfoDB 의 instance memeber array (요소 8ea, max 5개의 게시글)
 * 
 * */

package old.clientInfo;

public class PostInfoDB {
	
	private String[] postInfoArr = new String[40];
	private int countArr = 1;							// 배열(=게시글) 포화여부를 확인하기위한 flag (max 5)
	private int startIndex = 0;							// 배열의 시작번호 (DB의 primary key)
	
	
	// 배열의 주소를 반환 (test용) //
	public String[] getArr() {
		return this.postInfoArr;
	} // getArr() END
	
	
	// 배열의 전체 요소를 셋팅 //
	public void setAll(String bookName, String writer, String title, String content, String bookType, String favorite, String level, String score) {
		
		this.postInfoArr[startIndex]   = bookName;
		this.postInfoArr[startIndex+1] = writer;
		this.postInfoArr[startIndex+2] = title;
		this.postInfoArr[startIndex+3] = content;
		this.postInfoArr[startIndex+4] = bookType;
		this.postInfoArr[startIndex+5] = favorite;
		this.postInfoArr[startIndex+6] = level;
		this.postInfoArr[startIndex+7] = score;	
		
		this.startIndex += 8;			// 시작 인덱스 증가
		
	} // setAll() END
	
	
	// 배열에 저장가능한 공간을 확인(=게시글) //
	// 저장가능 : true , 저장불가 : false
	public boolean isEmpty() {
		
		boolean result = false;
		
		if(countArr>=1 && countArr<=5) {		// 저장가능
			this.countArr += 1;
			result = true;
		}
		return result;
		
	} // isEmpty() END
	
	
}// PostInfoDB END