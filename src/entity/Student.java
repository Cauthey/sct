package entity;

import java.util.Date;

/**
 * @name：Student
 * @Description：学生类
 * @Author：cauthy
 * @date：2023/4/1 14:12
 */
public class Student {
	/**
	 * 学号
	 */
	private int studentId;
	/**
	 * 学生姓名
	 */
	private String studentName;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 出生日期
	 */
	private Date birth;
	/**
	 * 年级
	 */
	private String grade;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 登陆密码
	 */
	private String password;
	/**
	 * 学生类型
	 */
	private String type;

	public Student() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 构造函数
	 * @param studentId
	 * @param studentName
	 * @param gender
	 * @param birth
	 * @param grade
	 * @param major
	 * @param password
	 */
	public Student(int studentId, String studentName, String gender, Date birth, String grade, String major, String password,String type) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.gender = gender;
		this.birth = birth;
		this.grade = grade;
		this.major = major;
		this.password = password;
		this.type=type;
	}

	/**
	 * @return studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return major
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
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
		return "学号：" + studentId + ", 姓名：" + studentName + ", 性别：" + gender + ", 出生年月："
				+ birth + ", 年级" + grade + ", 专业：" + major;
	}
}
