package entity;

/**
 * @name：Undergraduate
 * @Description：选课
 * @Author：cauthy
 * @date：2023/4/1 14:12
 */
public class StudentCourse {
	/**
	 * 课程id
	 */
	private int courseId;
	/**
	 * 学生id
	 */
	private int studentId;
	/**
	 * 学生成绩
	 */
	private Double score;
	/**
	 * @return courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	public StudentCourse() {
	}

	/**
	 * 构造函数
	 * @param courseId
	 * @param studentId
	 * @param score
	 */
	public StudentCourse(int courseId, int studentId, Double score) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.score = score;
	}
	/**
	 * @param courseId
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	 * @return score
	 */
	public Double getScore() {
		return score;
	}
	/**
	 * @param score
	 */
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentCourse [courseId=" + courseId + ", studentId=" + studentId + ", score=" + score + "]";
	}
}
