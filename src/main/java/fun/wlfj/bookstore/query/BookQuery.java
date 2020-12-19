package fun.wlfj.bookstore.query;

import fun.wlfj.bookstore.entity.BookType;

public class BookQuery {
	private Integer bookId;
	private String bookName;
	private String bookType;
	private Double bookPrice_low;
	private Double bookPrice_high;
	private String bookDetail;
	
	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Double getBookPrice_low() {
		return bookPrice_low;
	}

	public void setBookPrice_low(Double bookPrice_low) {
		this.bookPrice_low = bookPrice_low;
	}

	public Double getBookPrice_high() {
		return bookPrice_high;
	}

	public void setBookPrice_high(Double bookPrice_high) {
		this.bookPrice_high = bookPrice_high;
	}

	public BookQuery(Integer bookId, String bookName, String bookType, String bookDetail) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookDetail = bookDetail;
	}
	
	public BookQuery(String bookName, String bookType, String bookDetail) {
		this(null, bookName, bookType, bookDetail);
	}

	public BookQuery() {
		super();
	}

}
