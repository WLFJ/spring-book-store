package fun.wlfj.bookstore.entity;

import java.util.LinkedList;
import java.util.List;

public class UserGroup {
	private Integer groupId;
	private String groupName;
	private Integer bookPermission;
	private Integer typePermission;
	private Integer userPermission;

	private List<User> users;
	
	public boolean isPermissioned(PermissionableEntity entity, String oprType) {
		boolean res = false;
		switch(oprType) {
		case "r":
			res = entity.isReadable(getPermission(entity));
			break;
		case "w":
			res = entity.isWritable(getPermission(entity));
			break;
		case "x":
			res = entity.isAccessable(getPermission(entity));
			break;
		}
		return res;
	}
	
	private int getPermission(PermissionableEntity entity) {
		if(entity instanceof Book) {
			return bookPermission;
		}else if(entity instanceof BookType) {
			return typePermission;
		}else if(entity instanceof User) {
			return userPermission;
		}else return 0;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getBookPermission() {
		return bookPermission;
	}

	public void setBookPermission(Integer bookPermission) {
		this.bookPermission = bookPermission;
	}

	public Integer getTypePermission() {
		return typePermission;
	}

	public void setTypePermission(Integer typePermission) {
		this.typePermission = typePermission;
	}

	public Integer getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(Integer userPermission) {
		this.userPermission = userPermission;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public UserGroup(Integer groupId, String groupName, Integer bookPermission, Integer typePermission,
			Integer userPermission, List<User> users) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.bookPermission = bookPermission;
		this.typePermission = typePermission;
		this.userPermission = userPermission;
		this.users = users;
	}

	public UserGroup(Integer groupId, String groupName, Integer bookPermission, Integer typePermission,
			Integer userPermission) {
		this(groupId, groupName, bookPermission, typePermission, userPermission, new LinkedList<User>());
	}

	public UserGroup(String groupName, Integer bookPermission, Integer typePermission,
			Integer userPermission) {
		this(null, groupName, bookPermission, typePermission, userPermission);
	}

	public UserGroup() {
		super();
	}

	@Override
	public String toString() {
		return "UserGroup [groupId=" + groupId + ", groupName=" + groupName + ", bookPermission=" + bookPermission
				+ ", typePermission=" + typePermission + ", userPermission=" + userPermission + ", users=" + users
				+ "]";
	}

}
