package fun.wlfj.bookstore.entity;

public class Book extends AbstractEntity{
	private Integer bookId;
	private String bookName;
	private BookType bookType;
	private Double bookPrice;
	private String bookCover;
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

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookCover() {
		return bookCover;
	}

	public void setBookCover(String bookCover) {
		this.bookCover = bookCover;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Book(Integer bookId, String bookName, BookType bookType, Double bookPrice, String bookCover, String bookDetail) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookPrice = bookPrice;
		this.bookCover = bookCover;
		this.bookDetail = bookDetail;
	}

	public Book(String bookName, BookType bookType, Double bookPrice, String bookCover, String bookDetail) {
		this(null, bookName, bookType, bookPrice, bookCover, bookDetail);
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookType=" + bookType.getTypeName() + ", bookPrice="
				+ bookPrice + ", bookCover=" + bookCover + ", bookDetail=" + bookDetail + "]";
	}


}
