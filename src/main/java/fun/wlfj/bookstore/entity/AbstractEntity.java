package fun.wlfj.bookstore.entity;

public class AbstractEntity implements PermissionableEntity {

	@Override
	public boolean isReadable(int permission) {
		return (permission & 4) == 4;
	}

	@Override
	public boolean isWritable(int permission) {
		return (permission & 2) == 2;
	}

	@Override
	public boolean isAccessable(int permission) {
		return (permission & 1) == 1;
	}

}