package fun.wlfj.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.wlfj.bookstore.dao.BookDao;
import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.query.BookQuery;
import fun.wlfj.bookstore.service.BookService;

@Service
public class BookServeceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public boolean addBook(Book book) {
		return bookDao.addBook(book) == 1;
	}

	@Override
	public boolean deleteBook(int bookId) {
		return bookDao.deleteBook(bookId) == 1;
	}

	@Override
	public boolean updateBook(Book book) {
		return bookDao.updateBook(book) == 1;
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getBooks() {
		return queryBooks(new BookQuery());
	}

	@Override
	public List<Book> queryBooks(BookQuery bookQuery) {
		return bookDao.queryBooks(bookQuery);
	}

}
