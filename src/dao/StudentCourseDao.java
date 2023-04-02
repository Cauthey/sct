package dao;

import entity.StudentCourse;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class StudentCourseDao {
    /**
     * 选课
     * @param studentCourse
     * @return
     * @throws SQLException
     */
    public static boolean addStudentCourse(StudentCourse studentCourse) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO `studentCourse` (`courseId`, `studentId`) VALUES (?, ?)";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentCourse.getCourseId());
            ps.setInt(2, studentCourse.getStudentId());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

 public static boolean addStudentCourse(int courseId ,int studentId) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO `courseInfo` (`courseId`, `studentId`,) VALUES (?, ?)";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res = false;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, courseId);
            ps.setInt(2, studentId);
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 退课
     * @param courseId
     * @param studentId
     * @return
     * @throws SQLException
     */
    public static boolean deleteStudentCourse(int courseId, int studentId) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM studentcourse WHERE studentId = ? and courseId = ?";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 根据学生id查询所有课程
     * 根据课程id查所有的学生
     * @param studentId
     * @param courseId
     * @return
     * @throws SQLException
     */
    public static ArrayList<StudentCourse> searchStudentCourse(int studentId, int courseId) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM studentcourse WHERE studentId = ? or courseId = ?"; // SQL 查询语句
        PreparedStatement ps = null ; // 创建 PreparedStatement 对象
        ArrayList<StudentCourse> studentCourseList = new ArrayList<>();    // 接受查询结果
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, studentId); // 设置查询参数
            ps.setInt(2, courseId); // 设置查询参数
            rs = ps.executeQuery(); // 执行查询语句
            while (rs.next()) {
                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudentId(rs.getInt("studentId"));
                studentCourse.setCourseId(rs.getInt("courseId"));
                studentCourse.setScore(rs.getDouble("score"));
                studentCourseList.add(studentCourse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentCourseList;
    }
}
