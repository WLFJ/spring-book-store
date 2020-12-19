package fun.wlfj.bookstore.entity;

import java.util.LinkedList;
import java.util.List;

public class BookType extends AbstractEntity{
	private Integer typeId;
	private String typeName;
	private String typeDescription;

	private List<Book> books;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public BookType(Integer typeId, String typeName, String typeDescription, List<Book> books) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.books = books;
		this.typeDescription = typeDescription;
	}
	
	public BookType(String typeName, String typeDescription) {
		this(null, typeName, typeDescription, new LinkedList<Book>());
	}

	public BookType(int typeId, String typeName, String typeDescription) {
		this(typeId, typeName, typeDescription, null);
	}

	public BookType() {
		super();
	}

	@Override
	public String toString() {
		return "BookType [typeId=" + typeId + ", typeName=" + typeName + ", typeDescription=" + typeDescription
				+ ", books=" + books + "]";
	}

}
