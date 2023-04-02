package dao;

import entity.Teacher;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao {
    public static boolean addTeacher(Teacher teacher) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO `teachers` (`teacherId`, `teacherName`, `password`) VALUES (?, ?, ?)";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, teacher.getTeacherId());
            ps.setString(2, teacher.getTeacherName());
            ps.setString(3, teacher.getPassword());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public boolean updateTeacher(Teacher teacher) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE teachers SET teacherName=?, password=? WHERE teacherId = ?";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, teacher.getTeacherName());
            ps.setString(2, teacher.getPassword());
            ps.setInt(3, teacher.getTeacherId());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public boolean deleteTeacher(int teacherId) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM teachers WHERE teacherId = ?";
        PreparedStatement ps; // 创建 PreparedStatement 对象
        boolean res = false;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, teacherId);
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public static ArrayList<Teacher> searchTeacher(int teacherId, String teacherName) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM teachers WHERE teacherId = ? or teacherName like ?"; // SQL 查询语句
        PreparedStatement ps = null ; // 创建 PreparedStatement 对象
        ArrayList<Teacher> teachersList = new ArrayList<>();    // 接受查询结果
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, teacherId); // 设置查询参数
            ps.setString(2, "%"+teacherName+"%");
            rs = ps.executeQuery(); // 执行查询语句
            while (rs.next()) {
                Teacher teacherTmp = new Teacher();
                teacherTmp.setTeacherId(rs.getInt("teacherId"));
                teacherTmp.setTeacherName(rs.getString("teacherName"));
                System.out.println(teacherTmp);
                teachersList.add(teacherTmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachersList;
    }
    public boolean checkLoginPassport(int teacherId,String password) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM teachers WHERE teacherId = ? and password = ?"; // SQL 查询语句
        PreparedStatement ps; // 创建 PreparedStatement 对象
        ResultSet rs;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, teacherId);
            ps.setString(2, password);
            rs = ps.executeQuery(); // 执行查询语句
            if(!rs.next()){
                return false;
            }else{
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
