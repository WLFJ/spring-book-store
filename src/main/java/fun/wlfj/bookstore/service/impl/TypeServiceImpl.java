package fun.wlfj.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.wlfj.bookstore.dao.TypeDao;
import fun.wlfj.bookstore.entity.BookType;
import fun.wlfj.bookstore.query.TypeQuery;
import fun.wlfj.bookstore.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
	
	@Autowired
	private TypeDao typeDao;

	@Override
	public boolean addType(BookType type) {
		return typeDao.addType(type) == 1;
	}

	@Override
	public boolean deleteType(int typeId) {
		BookType type = typeDao.getTypeById(typeId);
		if(type != null)
			return typeDao.deleteType(type) == 1;
		else
			return false;
	}

	@Override
	public boolean updateType(BookType type) {
		return typeDao.updateType(type) == 1;
	}

	@Override
	public BookType getTypeById(int typeId) {
		return typeDao.getTypeById(typeId);
	}

	@Override
	public List<BookType> queryTypes(TypeQuery query) {
		return typeDao.queryTypes(query);
	}

	@Override
	public List<BookType> getTypes() {
		return queryTypes(new TypeQuery());
	}

}
