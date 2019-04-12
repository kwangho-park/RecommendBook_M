package dto;

public class PostInfoDto {

	private int num = 0;
	private String bookName = null;
	private String writer = null;
	private String title = null;
	private String content = null;
	private String bookType = null;
	private String favorite = null;
	private String bookLevel = null;
	private int score = 0;
	
	
	
	public PostInfoDto() {}
	
	// Overroading
	public PostInfoDto(int num, String bookName, String writer, String title, String content, String bookType,
			String favorite, String bookLevel, int score) {
		super();
		this.num = num;
		this.bookName = bookName;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.bookType = bookType;
		this.favorite = favorite;
		this.bookLevel = bookLevel;
		this.score = score;
	}

	// Overroading
	public PostInfoDto(String bookName, String writer, String title, String content, String bookType,
			String favorite, String bookLevel, int score) {
		super();
		this.bookName = bookName;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.bookType = bookType;
		this.favorite = favorite;
		this.bookLevel = bookLevel;
		this.score = score;
	}
	
	
	// getter, setter //
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getBookType() {
		return bookType;
	}


	public void setBookType(String bookType) {
		this.bookType = bookType;
	}


	public String getFavorite() {
		return favorite;
	}


	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}


	public String getBookLevel() {
		return bookLevel;
	}


	public void setBookLevel(String bookLevel) {
		this.bookLevel = bookLevel;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	
} // PostInfoDto END
