// 사용자 정보 DTO (userInfo table) //

package dto;

public class UserInfoDto {
	
	private String id = null;				// pk
	private int pw = 0;
	private String userName = null;
	private String birthday = null;			// 생년월일
	private String email = null;
	private String address = null;
	private String signUpProcess = null;	// 가입경로
	private String advertising = null;		// 광고수신여부
	
	public UserInfoDto() {}
	
	public UserInfoDto(String id, int pw, String userName, String birthday, String email, String address, String signUpProcess, String advertising) {
		
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.signUpProcess = signUpProcess;
		this.advertising = advertising;
	}

	// getter, setter // 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSignUpProcess() {
		return signUpProcess;
	}

	public void setSignUpProcess(String signUpProcess) {
		this.signUpProcess = signUpProcess;
	}

	public String getAdvertising() {
		return advertising;
	}

	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}
	
	
	
}
