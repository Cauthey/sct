package dao;

import entity.Admin;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {
    /**
     * 添加管理员
     * @param manager
     * @return
     * @throws SQLException
     */
    public static boolean addAdmin(Admin manager) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO `administrators` (`username`, `password`) VALUES (?, ?)";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, manager.getUsername());
            ps.setString(2, manager.getPassword());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 修改管理员密码
     *
     * @param manager
     * @return
     * @throws SQLException
     */
    public boolean updateAdmin(Admin manager) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE administrators SET password=? WHERE username=?";
        PreparedStatement ps = null; // 创建 PreparedStatement 对象
        boolean res;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, manager.getPassword());
            ps.setString(2, manager.getUsername());
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 删除管理员
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean deleteAdmin(String username) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM administrators WHERE username = ?";
        PreparedStatement ps; // 创建 PreparedStatement 对象
        boolean res = false;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            res = ps.executeUpdate() > 0 ;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    /**
     * 根据用户名模糊查询管理员
     * @param username
     * @return
     * @throws SQLException
     */
    public static ArrayList<Admin> searchAdmin(String username) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM administrators WHERE username like ? "; // SQL 查询语句
        PreparedStatement ps = null ; // 创建 PreparedStatement 对象
        ArrayList<Admin> adminsList = new ArrayList<>();    // 接受查询结果
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setString(1, "%"+username+"%");
            rs = ps.executeQuery(); // 执行查询语句
            while (rs.next()) {
                Admin adminTmp = new Admin();
                adminTmp.setUsername(rs.getString("username"));
                System.out.println(adminTmp);
                adminsList.add(adminTmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminsList;
    }

    /**
     * 检查管理员的登录信息
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public static boolean checkLoginPassport(String username, String password) throws SQLException {
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM administrators WHERE username = ? and password = ?"; // SQL 查询语句
        PreparedStatement ps;
        ResultSet rs = null;
        try { // 获取数据库连接
            ps=connection.prepareStatement(sql);
            ps.setString(1, username);
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
