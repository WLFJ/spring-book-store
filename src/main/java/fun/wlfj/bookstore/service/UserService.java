package fun.wlfj.bookstore.service;

import fun.wlfj.bookstore.entity.User;

//用户的CUD
//登陆操作
public interface UserService {
	public boolean addUser(User user);
	public User userLogin(String userName, String passWord);
	public User getUserById(int userId);
	public boolean deleteUser(int userId);
	public boolean updateUser(User user);
}
