package fun.wlfj.bookstore.dao;

import java.util.List;

import fun.wlfj.bookstore.entity.Book;
import fun.wlfj.bookstore.query.BookQuery;

//（2）图书详细信息管理：图书信息的增、删、改、查询；
//   a.其中图书信息包括图书编号、图书名称、图书类型、图书价格、图书封皮图片
//   b.查询要求可以按单条件查询（例如按图书编号或图书类型查询）；按多条件查询，同时满足多个条件查询，例如上面5个条件中选择3个（图书名称、图书类型、图书价格（价格按某一范围））或选择两个条件（图书类型、图书价格（价格按某一范围）），查询结果满足条件的可能有多条数据。
//   c.图书类型管理及每本图书信息增、删、改操作必须由具有系统管理员权限的用户完成，具有普通权限的用户不能执行管理操作。
public interface BookDao {
	public int addBook(Book book);
	public int deleteBook(int bookId);
	public int updateBook(Book book);
	public Book getBookById(int bookId);
	public List<Book> queryBooks(BookQuery bookQuery);
	public List<Book> getBookByTypeId(int typeId);
}
