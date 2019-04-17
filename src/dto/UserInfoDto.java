// 사용자 정보 DTO (userInfo table) //

package dto;

public class UserInfoDto {
	
	private String id;				// pk
	private String pw;
	private String userName;
	private String birthday;		// 생년월일
	private String email01;
	private String email02;
	private int postCode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	
	public UserInfoDto() {}
	
	public UserInfoDto(String id, String pw, String userName, String birthday, String email01, 
			String email02, int postCode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.birthday = birthday;
		this.email01 = email01;
		this.email02 = email02;
		this.postCode = postCode;
		this.roadAddress = roadAddress;
		this.jibunAddress = jibunAddress;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
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


	public String getEmail01() {
		return email01;
	}


	public void setEmail01(String email01) {
		this.email01 = email01;
	}


	public String getEmail02() {
		return email02;
	}


	public void setEmail02(String email02) {
		this.email02 = email02;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getRoadAddress() {
		return roadAddress;
	}


	public void setRoadAddress(String readAddress) {
		this.roadAddress = readAddress;
	}


	public String getJibunAddress() {
		return jibunAddress;
	}


	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}


	public String getDetailAddress() {
		return detailAddress;
	}


	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}


	public String getExtraAddress() {
		return extraAddress;
	}


	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	
	
	
}
