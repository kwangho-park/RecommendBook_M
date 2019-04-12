package dto;

public class RecommendInfoDto {


	private String bookName = null;
	private int averageScore = 0;
	private int counter = 0;
	
	
	
	public RecommendInfoDto() {}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}
	
	
	
}
