package seventh.dbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCTools {


	// 从配置文件中读入数据库的连接信息

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		InputStream inStream = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inStream);
		// 获取配置中的参数
		String driver = properties.getProperty("driver");
		String jdbcUrl = properties.getProperty("jdbcURL");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		Class.forName(driver);
		return (Connection) DriverManager.getConnection(jdbcUrl, user, password);

	}

	// 关闭连接
	public static void release(ResultSet resultSet, PreparedStatement pStatement,Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pStatement != null) {
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();}
			}
		}
	}