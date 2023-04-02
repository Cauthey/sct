package dao;

import entity.Postgraduate;
import entity.Student;
import entity.Undergraduate;
import utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {

    public static boolean addStudent(Undergraduate undergraduate,Postgraduate postgraduate) throws SQLException {
        if(undergraduate!=null){
            Connection connection = ConnectDB.getConnection();
            String sql = "INSERT INTO `students` (`studentId`, `studentName`, `gender`, `birth`,`grade`, `major`,`password`,`type`, `rankClass`,`headTeacher`) VALUES (?, ?, ?,?, ?, ?, ?,?,?,?)";
            PreparedStatement ps = null; // 创建 PreparedStatement 对象
            boolean res;
            try {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, undergraduate.getStudentId());
                ps.setString(2, undergraduate.getStudentName());
                ps.setString(3, undergraduate.getGender());
                ps.setDate(4, (Date) undergraduate.getBirth());
                ps.setString(5, undergraduate.getGrade());
                ps.setString(6, undergraduate.getMajor());
                ps.setString(7, undergraduate.getPassword());
                ps.setString(8, undergraduate.getType());
                ps.setString(9, undergraduate.getRankClass());
                ps.setString(10, undergraduate.getHeadTeacher());
                res = ps.executeUpdate() > 0 ;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return res;
        }
        if(postgraduate!=null){
            Connection connection = ConnectDB.getConnection();
            String sql = "INSERT INTO `students` (`studentId`, `studentName`, `gender`, `birth`,`grade`, `major`,`password`,`type`, `tutor`,`searchDirection`) VALUES (?, ?, ?,?, ?, ?, ?,?,?,?)";
            PreparedStatement ps = null; // 创建 PreparedStatement 对象
            boolean res;
            try {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, postgraduate.getStudentId());
                ps.setString(2, postgraduate.getStudentName());
                ps.setString(3, postgraduate.getGender());
                ps.setDate(4, (Date) postgraduate.getBirth());
                ps.setString(5, postgraduate.getGrade());
                ps.setString(6, postgraduate.getMajor());
                ps.setString(7, postgraduate.getPassword());
                ps.setString(8, postgraduate.getType());
                ps.setString(9, postgraduate.getTutor());
                ps.setString(10, postgraduate.getSearchDirection());
                res = ps.executeUpdate() > 0 ;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return res;
        }
        return false;
    }

    public boolean updateStudent(Student student) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "update students set studentName=?, gender=?, birth=?,greade=?, major=?,password=? where studentId = ?";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getGender());
            ps.setDate(3, (Date) student.getBirth());
            ps.setString(4, student.getMajor());
            ps.setString(5, student.getGrade());
            ps.setString(6, student.getPassword());
            ps.setInt(7, student.getStudentId());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public boolean deleteStudent(int id, String name) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM students WHERE studentId = ? or studentName = ?"; // SQL 查询语句
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            res = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static ArrayList<Student> searchStudent(int id, String name) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM students WHERE studentId = ? or studentName like ?"; // SQL 查询语句
        PreparedStatement ps = null ; // 创建 PreparedStatement 对象
        ArrayList<Student> studentList = new ArrayList<>();    // 接受查询结果
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id); // 设置查询参数
            ps.setString(2, "%"+name+"%");
            rs = ps.executeQuery(); // 执行查询语句
            while (rs.next()) {
                String type = rs.getString("type");
                if (type.equals("本科生")){
                    Undergraduate undergraduate = new Undergraduate();
                    undergraduate.setStudentId(rs.getInt("studentId"));
                    undergraduate.setStudentName(rs.getString("studentName"));
                    undergraduate.setGender(rs.getString("gender"));
                    undergraduate.setBirth(rs.getDate("birth"));
                    undergraduate.setGrade(rs.getString("grade"));
                    undergraduate.setMajor(rs.getString("major"));
                    undergraduate.setPassword(rs.getString("password"));
                    undergraduate.setType(rs.getString("type"));
                    undergraduate.setRankClass(rs.getString("rankClass"));
                    undergraduate.setHeadTeacher(rs.getString("headTeacher"));
                    System.out.println(undergraduate);
                    studentList.add(undergraduate);

                }else if(type.equals("研究生")){
                    Postgraduate postgraduate =new Postgraduate();
                    postgraduate.setStudentId(rs.getInt("studentId"));
                    postgraduate.setStudentName(rs.getString("studentName"));
                    postgraduate.setGender(rs.getString("gender"));
                    postgraduate.setBirth(rs.getDate("birth"));
                    postgraduate.setGrade(rs.getString("grade"));
                    postgraduate.setMajor(rs.getString("major"));
                    postgraduate.setPassword(rs.getString("password"));
                    postgraduate.setType(rs.getString("type"));
                    postgraduate.setTutor(rs.getString("tutor"));
                    postgraduate.setSearchDirection(rs.getString("searchDirection"));
                    System.out.println(postgraduate);
                    studentList.add(postgraduate);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    /**
     * 检查学生登录账号密码
     * @param studentId
     * @param password
     * @return
     * @throws SQLException
     */
    public static boolean checkLoginPassport(int studentId, String password) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM students WHERE studentId = ? and password = ?"; // SQL 查询语句
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1, studentId);
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
