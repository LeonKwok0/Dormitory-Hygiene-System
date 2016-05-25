package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static final ConnectionFactory factory = new ConnectionFactory();
	private Connection conn = null;

	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in); // 读取配置文件
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Can not load Databse File ", "Error:", JOptionPane.ERROR_MESSAGE);
		}

		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	private ConnectionFactory() {

	}

	// 返回一个ConnectionFactory 实例对象
	public static ConnectionFactory getInstance() {
		return factory;
	}

	// establish database connection
	public Connection makeConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can not establish a database connection"
					+ "\nThis version need remote database"
					+ "\n(demo until June 9)to suporrt."
					+ "\nPlease check your Internet", "Error:",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return conn;
	}

}
