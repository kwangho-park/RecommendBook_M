package service;

import dto.RecommendInfoDto;

public class AverageScoreCal {


	public AverageScoreCal(){}
	
	// 평균 추천점수를 연산 (추가) // 
	public void addition(int score, RecommendInfoDto recommendInfoDto) {
		
		int averageScore = recommendInfoDto.getAverageScore();
		int counter = recommendInfoDto.getCounter();
		
		int result = 0;
		
		
		result = ((averageScore * counter) + score) / (counter+1); 
		
		
		// set result at DTO
		recommendInfoDto.setAverageScore(result);
		recommendInfoDto.setCounter(counter+1);
		
	}// addition() END
	
	
	
	// 평균 추천점수를 연산 (뺴기) //
	// 동작 조건 : 게시글 수정 시 도서명 변경, 게시글 삭제
	public void subtraction(int beforeScore, RecommendInfoDto recommendInfoDto) {
		 
		int averageScore = recommendInfoDto.getAverageScore();
		int counter = recommendInfoDto.getCounter();
		
		int result = 0;
		
		if(counter != 1) {
			result = ((averageScore * counter) - beforeScore) / (counter-1);
			
			recommendInfoDto.setAverageScore(result);
			recommendInfoDto.setCounter(counter-1);
			
		}else {
			recommendInfoDto.setAverageScore(result);
			recommendInfoDto.setCounter(counter-1);
		}
		
	}// subtraction() END
	
	
	
	
	// 평균 추천점수를 연산 (수정) // 
	public void modify(int score, int beforeScore, RecommendInfoDto recommendInfoDto) {
		
		int averageScore = recommendInfoDto.getAverageScore();
		int counter = recommendInfoDto.getCounter();
		
		int result = 0;
		
		result = ((averageScore * counter) - beforeScore + score) / counter;
		
		recommendInfoDto.setAverageScore(result);
		
	} // modify() END
	
	
}// AverageScoreCal END
