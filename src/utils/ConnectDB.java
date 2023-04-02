package utils;
import java.sql.*;

public class ConnectDB {
    private static final String USERNAME = "root"; // 数据库用户名
    private static final String PASSWORD = "123456"; // 数据库密码
    private static final String URL = "jdbc:mysql://localhost:3306/studentCT?useUnicode=true&characterEncoding=UTF-8"; // 数据库连接地址
    private static Connection connection = null;

    /**
     * 连接数据库
     * @return
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        if(connection ==null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
