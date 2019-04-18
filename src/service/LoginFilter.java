package service;

import java.util.ArrayList;

import dto.UserInfoDto_old;

public class LoginFilter {

	ArrayList<UserInfoDto_old> dto = null;
	
	// 사용자 입력 정보 //
	String loginId = null;
	int loginPw = 0;
	
	// db 정보//
	String dbId = null;
	int dbPw = 0;

	
	public LoginFilter(){}

	
	// 사용자 입력 data와 db data를 비교하는 method //
	public boolean filter() {
		
		boolean result = false;

		
		// forEach 문으로 list의 모든 element를 호출
		for(UserInfoDto_old userInfoDto:dto) {
			
			dbId = userInfoDto.getId();
			dbPw = userInfoDto.getPw();

			if(dbId.equals(loginId)) {
				if(dbPw == loginPw){
					result = true;	
					break;
				}	
			}
		}

		return result;
	}// loginFilter() END


	
	
	
	
	// getter, setter //

	public ArrayList<UserInfoDto_old> getDto() {
		return dto;
	}


	public void setDto(ArrayList<UserInfoDto_old> dto) {
		this.dto = dto;
	}


	public String getInputId() {
		return loginId;
	}


	public void setInputId(String inputId) {
		this.loginId = inputId;
	}


	public int getInputPw() {
		return loginPw;
	}


	public void setInputPw(int inputPw) {
		this.loginPw = inputPw;
	}


	public String getDbId() {
		return dbId;
	}


	public void setDbId(String dbId) {
		this.dbId = dbId;
	}


	public int getDbPw() {
		return dbPw;
	}


	public void setDbPw(int dbPw) {
		this.dbPw = dbPw;
	}
	
	
	

	
	
	
	
}// LoginFilter END
