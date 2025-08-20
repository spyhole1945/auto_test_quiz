package Utils;
import java.sql.*;
import java.util.ArrayList;

public class mysql {
	private String ip;
	private String database;
	private String username;
	private String password;
	private Connection con;


	public mysql(String ip, String database, String username, String password) throws SQLException

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


	/**��ѯ��������ȡ����
	 *
	 * @param sql: ��ѯ���
	 * @param columnName:Ҫ��ѯ���ֶ�
	 * @return ���ش���ѯ�ֶ�
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
		//System.out.println("��ѯsql:" + sql);
		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				list.add(rs.getString(columnName));
			}

			//�ر�����
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("sqlexception :" + ex.getMessage());
		}
		return list;
	}public String selectData(String sql, String columnName) throws SQLException

	{
		DBconn dBconn=new DBconn();
		this.con= dBconn.getConnection(ip,database,username,password);

		Statement stmt;
		String name = null;
		int no;
		//System.out.println("��ѯsql:" + sql);
		try {

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				name=rs.getString(columnName);
			}

			//�ر�����
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			System.err.println("sqlexception :" + ex.getMessage());
		}
		return name;
	}

	/**ִ��ɾ����ѯ
	 * (������)
	 * @param sql:ִ��ɾ��������sql
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
			   //ִ�в�ѯ���
			   //sql=conSql;
			   stmt.executeUpdate(sql);
			   //�ر�����
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
			
			
			   //�ر�����
			   stmt.close();	
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }
		}
		//���·�������������
		public  void InsertData(String sql) throws SQLException {

			DBconn dBconn=new DBconn();
			this.con= dBconn.getConnection(ip,database,username,password);
			Statement stmt;

			  try
			  {
			   //con=DriverManager.getConnection(urlstr,this.username,this.password);
			   stmt=con.createStatement();
			   //ִ�в������
			   //sql=conSql; //sql="insert into test values(2222,'wang')";
			   stmt.executeUpdate(sql);
			   //�ر�����
			   stmt.close();
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }
		}

	/**
	 * ���²���
	 * @param sql:ִ�и��µ����
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
			   ִ�в������
			   sql=conSql; //sql="insert into test values(2222,'wang')";
			   */
				  stmt.executeUpdate(sql);
			   //�ر�����
			   stmt.close();
			   con.close();
			  }catch(SQLException ex)
			  {
			   System.err.println("sqlexception :"+ex.getMessage());
			  }

		}

	public static void main(String[] args) throws SQLException {
		//String member_id="15048";
		mysql msql=new mysql("123.56.232.53","test","QA","qjs@Aw2ff2M#fM");



		/*String count="select count(*) rowNum from TestUser;";
		String countResult=msql.selectData(count,"rowNum");
		System.out.println("����ǰ����:"+countResult);

		String updateSql="INSERT INTO TestUser VALUES('Mary','sdksd','15629293030')";
		msql.updateData(updateSql);

		String count1="select count(*) rowNum from TestUser;";
		String countResult1=msql.selectData(count,"rowNum");
		System.out.println("����ǰ�к�:"+countResult1);*/


		String selectSql="select * from TestUser WHERE flag=\"1\";";
		//String beforeresult=msql.selectData(selectSql,"username");
		ArrayList<String> list=new ArrayList<String>();
		list=msql.selectMoreData(selectSql,"username");
		for (String str:list){
			System.out.println("�û���:"+str);
		}

		/*String updateSql="UPDATE uc_member SET member_mobile=\"13311073589\" where member_id=\""+member_id+"\";";
		msql.updateData(updateSql);

		String afterresult=msql.selectData(selectSql,"member_mobile");
		System.out.println("���º��ֻ���:"+afterresult);*/
	}

}
