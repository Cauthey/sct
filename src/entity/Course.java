package entity;

/**
 * @name：Course
 * @Description：课程
 * @Author：cauthy
 * @date：2023/4/1 14:12
 */
public class Course {
	/**
	 * 课程id
	 */
	private int courseId;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 老师id
	 */
	private int teacherId;
	/**
	 *  老师姓名
	 */
	private String teacherName;
	/**
	 * 课程介绍
	 */
	private String introduction;
	/**
	 * 课程学分
	 */
	private int academicCredit;

	public Course() {
	}

	/**
	 * 构造函数
	 * @param courseId
	 * @param courseName
	 * @param teacherId
	 * @param teacherName
	 * @param introduction
	 * @param academicCredit
	 */
	public Course(int courseId, String courseName, int teacherId, String teacherName, String introduction,
				  int academicCredit) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.introduction = introduction;
		this.academicCredit = academicCredit;
	}
	/**
	 * @return courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	 * @return introduction
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * @param introduction
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * @return academicCredit
	 */
	public int getAcademicCredit() {
		return academicCredit;
	}
	/**
	 * @param academicCredit
	 */
	public void setAcademicCredit(int academicCredit) {
		this.academicCredit = academicCredit;
	}

	@Override
	public String toString() {
		return "课程[" +
				"课程编号：" + courseId +
				", 课程名称：" + courseName +
				", 代课老师名称：" + teacherName +
				", 课程介绍：" + introduction +
				", 学分：" + academicCredit + ']';
	}
}
