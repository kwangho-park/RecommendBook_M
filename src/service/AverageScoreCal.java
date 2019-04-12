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
	public void subtraction(int beforeScore, RecommendInfoDto recommendInfoDto2) {
		 
		int averageScore = recommendInfoDto2.getAverageScore();
		int counter = recommendInfoDto2.getCounter();
		
		int result = 0;
		
		result = ((averageScore * counter) - beforeScore) / (counter-1);
		
		recommendInfoDto2.setAverageScore(result);
		recommendInfoDto2.setCounter(counter-1);
		
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
