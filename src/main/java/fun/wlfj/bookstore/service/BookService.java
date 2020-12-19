package fun.wlfj.bookstore.service;

import java.util.List;

import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.query.BookQuery;

public interface BookService {
	public boolean addBook(Book book);
	public boolean deleteBook(int bookId);
	public boolean updateBook(Book book);
	public Book getBookById(int bookId);
	public List<Book> getBooks();
	public List<Book> queryBooks(BookQuery bookQuery);
}
