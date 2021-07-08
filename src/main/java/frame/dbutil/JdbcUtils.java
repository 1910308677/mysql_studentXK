package frame.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	// 定义变量
	private static Properties props = null;
	// 静态块
	static {
		try {
			/*
			 * 1.加载配置文件 2.加载驱动类 3.调用DriverManager.getConnection
			 */
			// 加载配置文件
			InputStream in = JdbcUtils.class.getClassLoader()
					.getResourceAsStream("dbutil/db.properties");
			props = new Properties();
			props.load(in);
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取Connection
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		// 得到Connection
		return DriverManager.getConnection(props.getProperty("url"), props.getProperty("userName"),
				props.getProperty("password"));
	}
}
