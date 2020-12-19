package fun.wlfj.bookstore.dao;

import java.util.List;

import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.query.TypeQuery;

//（1）图书类型管理：图书类型信息增、删、改、查询；
public interface TypeDao {
	public int addType(BookType type);
	public int deleteType(BookType type);
	public int updateType(BookType type);
	public BookType getTypeById(int typeId);
	public List<BookType> queryTypes(TypeQuery query);
}
