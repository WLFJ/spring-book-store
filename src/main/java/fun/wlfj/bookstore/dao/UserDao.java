package fun.wlfj.bookstore.dao;

import java.util.List;

import fun.wlfj.bookstore.entity.User;

//（3）用户信息（包括用户ID、用户名称、密码、用户权限）管理：增、删、改、查操作。
public interface UserDao {
	public int addUser(User user);
	public int deleteUser(User user);
	public int updateUser(User user);
	public User getUserByUserName(String userName);
	public User getUserById(int userId);
	public List<User> getUserByGroupId(int groupId);
}
