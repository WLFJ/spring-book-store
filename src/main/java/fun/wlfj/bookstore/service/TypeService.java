package fun.wlfj.bookstore.service;

import java.util.List;

import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.query.TypeQuery;

public interface TypeService {
	public boolean addType(BookType type);
	public boolean deleteType(int typeId);
	public boolean updateType(BookType type);
	public BookType getTypeById(int typeId);
	public List<BookType> queryTypes(TypeQuery query);
	public List<BookType> getTypes();
}
