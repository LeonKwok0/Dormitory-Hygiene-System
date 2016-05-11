package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	private static final ConnectionFactory factory=new ConnectionFactory();
	private Connection conn=null;
	
	
	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in); // 读取配置文件
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("配置文件读取错误");
		}

		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");  
	}

	
	private ConnectionFactory(){
		
	} 
	
//	返回一个ConnectionFactory 实例对象 
	public static ConnectionFactory getInstance(){
		return factory;
	}
	
	
// 建立数据库连接 
	public  Connection makeConnection(){
		Connection conn=null;
		try{
			Class.forName(driver);
			conn= DriverManager.getConnection(dburl,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	
}
