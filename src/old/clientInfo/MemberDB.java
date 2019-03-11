package old.clientInfo;

//= 임시 DAO + DB의 역활의 클래스
public class MemberDB {

	// id, pw, name, email, address = String
	
	// element 5개 단위로 동일한 회원의 정보
	private String[] memberArr = new String[20];		// 회원은 4명만 가입받음 (임시)
	private int startNum = 0;
	private int memberNum = 0;							// 회원번호

	// 회원가입 시 발생하는 parameter를 전달받기위한 용도
	private String signUpId = "";
	private String signUpPw = "";
	private String signUpName = "";
	private String signUpEmail = "";
	private String signUpAddress = "";
	
	// 로그인 시 발생하는 parameter를 전달받기위한 용도
	private String loginId = "";
	private String loginPw = "";
	
	
	// getter, setter //
	public int getMemberNum() { return this.memberNum;	}
	
	
	// instance method의 전달인자를 대체하기 위한 (임시) getter, setter //
	public String getsignUpId() { return this.signUpId;	}
	public void setsignUpId(String signUpId) {	this.signUpId =signUpId;	}
	
	public String getsignUpPw() { return this.signUpPw;	}
	public void setsignUpPw(String signUpPw) {	this.signUpPw =signUpPw;	}
	
	public String getsignUpName() { return this.signUpName;	}
	public void setsignUpName(String signUpName) {	this.signUpName =signUpName;	}
	
	public String getsignUpEmail() { return this.signUpEmail;	}
	public void setsignUpEmail(String signUpEmail) {	this.signUpEmail =signUpEmail;	}
	
	public String getsignUpAddress() { return this.signUpAddress;	}
	public void setsignUpAddress(String signUpAddress) {	this.signUpAddress =signUpAddress;	}


	
	public String getLoginId() { return this.loginId;	}
	public void setLoginId(String loginId) {	this.loginId = loginId;	}
	
	public String getLoginPw() { return this.loginPw;	}
	public void setLoginPw(String loginPw) {	this.loginPw = loginPw;	}

	

	// 배열 element의 full check //
	public boolean isFull() {
		
		boolean result = false;
		
		if(this.memberArr[15] != null) {			// 4번째 입력된 id값으로 필터링
			result = true;
		}
		
		return result;
	} // isFull() END


	
	// id중복 확인용 method //
	// 중복되는 id가 배열에 존재 할 경우 false 반환
	public boolean idFilter() {

		boolean result = true;

		for(int index=0 ; index<20 ; index+=5) {

			if(this.signUpId.equals(this.memberArr[index])) {		// id 저장하는 element index : 0,5,10,15 
				result = false;
			}
		}
		return result;

	} // idFilter() END
	

	// 회원정보를 저장하는 method // 
	// jsp action tag로 넘겨받은 정보를 setting
	public void setMemberArr() {
		this.memberArr[this.startNum] = this.signUpId;	
		this.memberArr[this.startNum+1] = this.signUpPw;
		this.memberArr[this.startNum+2] = this.signUpName;
		this.memberArr[this.startNum+3] = this.signUpEmail;
		this.memberArr[this.startNum+4] = this.signUpAddress;
		
		this.startNum += 5;
		this.memberNum += 1;
	}
	
	/////////////////////////////////////////////////////////////////////////
	

	
	// 로그인 필터링을 위한 id,pw 비교 메소드 // 
	public boolean loginFilter() {

		boolean result = false;

		for(int index=0 ; index<4 ; index++) {

			if(this.loginId.equals(this.memberArr[index*5])) {		// id 저장하는 element index : 0,5,10,15
				
				if(this.loginPw.equals(this.memberArr[index*5+1])) {
					result = true;	
				}	
			}
		}
		return result;

	} // loginFilter() END

	
} // MemberDB END