package test;

import dao.Dao;
import dto.UserInfoDto;

public class TestMain {

	public static void main(String[] args) {

		UserInfoDto userInfoDto = new UserInfoDto("admin",1234,"박광호","910410","kwangho410@naver.com","서울시","인터넷검색","미수신");
		
		Dao dao = new Dao();
		
		dao.insertUserInfo(userInfoDto);
		
	}// main() END
	
	
}// TestMain END
