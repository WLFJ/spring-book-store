package fun.wlfj.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.wlfj.bookstore.dao.UserGroupDao;
import fun.wlfj.bookstore.entity.UserGroup;
import fun.wlfj.bookstore.service.UserGroupService;

@Service
public class UserGroupServiceImpl implements UserGroupService {
	
	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public boolean addUserGroup(UserGroup userGroup) {
		return userGroupDao.addGroup(userGroup) == 1;
	}

	@Override
	public boolean deleteUserGroup(int groupId) {
		UserGroup group = getUserGroupById(groupId);
		if(group == null) return false;
		return userGroupDao.deleteGroup(group) == 1;
	}

	@Override
	public boolean updateUserGroup(UserGroup userGroup) {
		return userGroupDao.updateGroup(userGroup) == 1;
	}

	@Override
	public UserGroup getUserGroupById(int groupId) {
		return userGroupDao.getGroupGyId(groupId);
	}

	@Override
	public List<UserGroup> getUserGroups() {
		return userGroupDao.getGroups();
	}



}
