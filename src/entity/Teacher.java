package entity;

/**
 * @name：Teacher
 * @Description：老师
 * @Author：cauthy
 * @date：2023/4/1 14:12
 */
public class Teacher {
	/**
	 * 老师id
	 */
	private int teacherId;
	/**
	 * 老师姓名
	 */
	private String teacherName;
	/**
	 * 老师登录密码
	 */
	private String password;

	public Teacher() {
	}

	/**
	 * 构造函数
	 * @param teacherId
	 * @param teacherName
	 * @param password
	 */
	public Teacher(int teacherId, String teacherName, String password) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.password = password;
	}
	/**
	 * @return teacherId
	 */
	public int getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherId
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * @return teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * @param teacherName
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
		return "老师 [职工编号：" + teacherId + ", 姓名：" + teacherName + "]";
	}
}
