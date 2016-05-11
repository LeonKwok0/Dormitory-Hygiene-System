package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

/**
 * 用来获取表的记录、
 * 
 * @author moxjane
 *
 */
public class QueryTable {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private  Vector columnHeads;
	private  Vector rowdata;

	public void Query(String sql) {
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			// 建立数据库连接
			st = conn.createStatement();
			// 获取statement实例
			rs = st.executeQuery(sql);
			// 获取结果集
			getResultset(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getResultset(ResultSet rs) throws SQLException {
		// 返回是否有第一条记录
		boolean record = rs.next();
		if (!record) {
			System.out.println("表中无值 Empaty table");
			return;
		}
		columnHeads = new Vector();
		rowdata = new Vector();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			// ResultSetMetaData 对象获取数据表的信息
			// getColumnCount() 获取列数

			// 获取表单标题
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				columnHeads.addElement(rsmd.getColumnName(i));
				// 向标题vector对象添加元素
			}

			// 获取表单内容
			do {
				rowdata.addElement(getOneRow(rs, rsmd));
			} while (rs.next());
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	public Vector getOneRow(ResultSet rs, ResultSetMetaData rsmd ) throws SQLException{
		 Vector currentRow = new Vector(); 
		
		for ( int i = 1; i <= rsmd.getColumnCount(); ++i ){
			currentRow.addElement( rs.getString(i));	
			}
		//返回一条记录 
		return currentRow; 
	}

	public Vector getColumnHeads() {
		return columnHeads;
	}

	public Vector getRowdata() {
		return rowdata;
	}
	
	public void closeConn(){
		try {
			rs.close();
			//断开数据库连接
			conn.close(); 
		}catch ( SQLException sqlex ) {
			System.err.println( "Unable  disconnect 断开数据库连接失败 " );
			sqlex.printStackTrace();
		}
	
	}
	

}
