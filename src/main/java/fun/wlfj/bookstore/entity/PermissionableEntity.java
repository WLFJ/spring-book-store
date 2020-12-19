package fun.wlfj.bookstore.entity;

public interface PermissionableEntity {
	boolean isReadable(int permission);
	boolean isWritable(int permission);
	boolean isAccessable(int permission);
}
