package entity;
/**
 * @name：Admin
 * @Description：管理员
 * @Author：Yanhexi
 * @date：2023/4/1 14:12
 */
public class Admin {
	/**
	 * 管理员登陆用户名
	 */
	private String username;
	/**
	 * 管理员登陆密码
	 */
	private String password;

	public Admin() {
	}

	/**
	 * 构造函数
	 * @param username
	 * @param password
	 */
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "管理员[" + "用户名：" + username + ']';
	}
}
