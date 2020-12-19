package fun.wlfj.bookstore.service;

import java.util.List;

import fun.wlfj.bookstore.entity.UserGroup;

//用户组的CUD
//提供权限查询接口
public interface UserGroupService {
	public boolean addUserGroup(UserGroup userGroup);
	public boolean deleteUserGroup(int groupId);
	public boolean updateUserGroup(UserGroup userGroup);
	public UserGroup getUserGroupById(int groupId);
	public List<UserGroup> getUserGroups();
}
