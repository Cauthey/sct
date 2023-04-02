package dao;

import entity.Course;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDao {
    /**
     *
     * @param course
     * @return
     * @throws SQLException
     */
    public static boolean addCourse(Course course) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO `courseInfo` (`courseId`, `courseName`, `teacherId`, `teacherName`, `introduction`,`academicCredit`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseName());
            ps.setInt(3, course.getTeacherId());
            ps.setString(4, course.getTeacherName());
            ps.setString(5, course.getIntroduction());
            ps.setInt(6, course.getAcademicCredit());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     *
     * @param course
     * @return
     * @throws SQLException
     */
    public boolean updateCourse(Course course) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "update courseInfo set courseName=?, teacherId=?, teacherName=?, introduction=?,academicCredit=? where courseId = ?";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getTeacherId());
            ps.setString(3, course.getTeacherName());
            ps.setString(4, course.getIntroduction());
            ps.setInt(5, course.getAcademicCredit());
            ps.setInt(6, course.getCourseId());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteCourse(int id) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM courseInfo WHERE courseId = ?"; // SQL 查询语句
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     *
     * @param id
     * @param name
     * @param teacherId
     * @param teacherName
     * @return ArrayList<Course>
     * @throws SQLException
     */
    public static ArrayList<Course> searchCourse(int id, String name, int teacherId, String teacherName) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM courseInfo WHERE courseId = ? or courseName like ? or teacherId = ? or teacherName = ?"; // SQL 查询语句
        PreparedStatement ps = null ; // 创建 PreparedStatement 对象
        ArrayList<Course> coursesList = new ArrayList<>();    // 接受查询结果
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id); // 设置查询参数
            ps.setString(2, "%"+name+"%");
            ps.setInt(3, teacherId); // 设置查询参数
            ps.setString(4, teacherName);
            rs = ps.executeQuery(); // 执行查询语句
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setTeacherId(rs.getInt("teacherId"));
                course.setTeacherName(rs.getString("teacherName"));
                course.setIntroduction(rs.getString("introduction"));
                System.out.println(course);
                coursesList.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return coursesList;
    }
}
