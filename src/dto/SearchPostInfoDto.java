package dto;

public class SearchPostInfoDto {

	private String bookName = null;
	private String writer = null;
	private int averageScore = 0;
	
	// Overloading
	public SearchPostInfoDto() {}
	
	// Overloading
	public SearchPostInfoDto(String bookName, String writer, int averageScore) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.averageScore = averageScore;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}
	
	
	
} // SearchPostInfoDto END
