package fun.wlfj.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.wlfj.bookstore.dao.UserDao;
import fun.wlfj.bookstore.entity.User;
import fun.wlfj.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user) == 1;
	}

	@Override
	public User userLogin(String userName, String passWord) {
		User user = userDao.getUserByUserName(userName);
		if (user != null && user.getPassWord().equals(passWord))
			return user;
		else
			return null;
	}

	@Override
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public boolean deleteUser(int userId) {
		User user = getUserById(userId);
		return !(user == null || userDao.deleteUser(user) != 1);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user) == 1;
	}

}
