package Utils;
//import snapChat.ChatLogToMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MysqlUtil {
	private String ip;
	private String database;
	private String username;
	private String password;
	private Connection con;


	public MysqlUtil(String ip, String database, String username, String password) throws SQLException

	{
		this.ip=ip;
		this.database=database;
		this.username=username;
		this.password=password;
		/*DBconn dBconn=new DBconn();
		this.con= dBconn.getConnection(ip,database,username,password);*/

		//System.out.println("IP:"+ip);
		System.out.println("database: "+database);
		/*System.out.println("username"+username);
		System.out.println("password"+password);*/
		
		
	}

	/**查询方法，获取数据
	 *
	 * @param sql: 查询语句
	 * @param columnName:要查询的字段
	 * @return 返回待查询字段
	 * @throws SQLException
     */
	public ArrayList<String> selectMoreData(String sql, String columnName) throws SQLException

	{
		DBconn dBconn=new DBconn();
		this.con= dBconn.getConnection(ip,database,username,password);

		Statement stmt;
		//String name = null;
		ArrayList<String> list=new ArrayList<String>();
		int no;
		//System.out.println("查询sql:" + sql);
		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			/*if(rs.next()){
				list.add(rs.getString(columnName));
			}*/
			while (rs.next())
			{
				list.add(rs.getString(columnName));
			}


			//关闭连接
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("sqlexception :" + ex.getMessage());
		}
		return list;
	}


	public String selectData(String sql, String columnName) throws SQLException

	{
		DBconn dBconn=new DBconn();
		this.con= dBconn.getConnection(ip,database,username,password);

		Statement stmt;
		String name = null;
		int no;
		//System.out.println("查询sql:" + sql);
		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				name=rs.getString(columnName);
			}

			//关闭连接
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("sqlexception :" + ex.getMessage());
		}
		return name;
	}

	/**执行删除查询
	 * (待调试)
	 * @param sql:执行删除操作的sql
     */
		public void deleteData(String sql) throws SQLException {
			DBconn dBconn=new DBconn();
			this.con= dBconn.getConnection(ip,database,username,password);
			/*String urlstr="jdbc:mysql://172.16.50.221:3306/ufenqi_db?zeroDateTimeBehavior=convertToNull";
			Connection con;
			String sql;*/
			Statement stmt;
			
			 /* try
			  {
			   Class.forName("com.mysql.jdbc.Driver");
			  }
			  catch(ClassNotFoundException e)
			  {
			   System.err.print("classnotfoundexception :");
			   System.err.print(e.getMessage());
			  }*/
			 /* try
			  {
			   //con=DriverManager.getConnection(urlstr,"root","ufenqi@123");
			   stmt=con.createStatement();
			   //执行查询语句
			   //sql=conSql;
			   stmt.executeUpdate(sql);
			   //关闭连接
			   stmt.close();	
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }*/
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			con.close();
		}
		public void execute_Procedure(String Procedure, long name)
		{
			String urlstr="jdbc:mysql://172.16.50.221:3306/ufenqi_db?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
			Connection con;
			String procedure;
			long username;
			Statement stmt;
			
			  try
			  {
			   Class.forName("com.mysql.jdbc.Driver");
			  }
			  catch(ClassNotFoundException e)
			  {
			   System.err.print("classnotfoundexception :");
			   System.err.print(e.getMessage());
			  }
			  try
			  {
			   con= DriverManager.getConnection(urlstr,"root","ufenqi@123");
			   stmt=con.createStatement();
			   procedure=Procedure;
			   username=name;
			   CallableStatement call=con.prepareCall("{"+procedure+"("+"?"+")}");
			
			   call.setLong(1, username);
			   call.execute();
			
			
			   //关闭连接
			   stmt.close();	
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }
		}
		//更新方法，更新数据
		public  void InsertData(String sql) throws SQLException {

			DBconn dBconn=new DBconn();
			this.con= dBconn.getConnection(ip,database,username,password);
			Statement stmt;

			  try
			  {
			   //con=DriverManager.getConnection(urlstr,this.username,this.password);
			   stmt=con.createStatement();
			   //执行插入语句
			   //sql=conSql; //sql="insert into test values(2222,'wang')";
			   stmt.executeUpdate(sql);
			   //关闭连接
			   stmt.close();
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }
		}

	/**
	 * 更新操作
	 * @param sql:执行更新的语句
     */
		public void updateData(String sql) throws SQLException {
			DBconn dBconn=new DBconn();
			this.con= dBconn.getConnection(ip,database,username,password);

			Statement stmt;

			  try
			  {

			  // con=DriverManager.getConnection(urlstr,"root","");
			   stmt=con.createStatement();
			   /*
			   执行插入语句
			   sql=conSql; //sql="insert into test values(2222,'wang')";
			   */
				  stmt.executeUpdate(sql);
			   //关闭连接
			   stmt.close();
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }

		}

	public static void main(String[] args) throws SQLException {
		//MysqlUtil mysql=new MysqlUtil("rm-2zeez363f4vas7893eo.mysql.rds.aliyuncs.com","tiktokanalysis","wehub_rw","1KSPtuLe");



	/*	String selectSql="select * from TestUser WHERE flag=\"1\";";
		//String beforeresult=msql.selectData(selectSql,"username");
		ArrayList<String> list=new ArrayList<String>();
		list=msql.selectMoreData(selectSql,"username");
		for (String str:list){
			System.out.println("用户名:"+str);
		}*/

		/*String updateSql="UPDATE uc_member SET member_mobile=\"13311073589\" where member_id=\""+member_id+"\";";
		msql.updateData(updateSql);

		String afterresult=msql.selectData(selectSql,"member_mobile");
		System.out.println("更新后手机号:"+afterresult);*/
	}

}
