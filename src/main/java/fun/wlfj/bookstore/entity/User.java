package fun.wlfj.bookstore.entity;

public class User extends AbstractEntity{
	private Integer userId;
	private String userName;
	private String passWord;
	private UserGroup userGroup;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public User(Integer userId, String userName, String passWord, UserGroup userGroup) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.userGroup = userGroup;
	}

	public User(String userName, String passWord, UserGroup userGroup) {
		this(null, userName, passWord, userGroup);
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userGroup="
				+ userGroup.getGroupName() + "]";
	}

}
