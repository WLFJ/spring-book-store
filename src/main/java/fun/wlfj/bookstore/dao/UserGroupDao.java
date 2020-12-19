package fun.wlfj.bookstore.dao;

import java.util.List;

import fun.wlfj.bookstore.entity.UserGroup;

public interface UserGroupDao {
	public int addGroup(UserGroup group);
	public int deleteGroup(UserGroup group);
	public int updateGroup(UserGroup group);
	public List<UserGroup> getGroups();
	public UserGroup getGroupGyId(int groupId);
}
