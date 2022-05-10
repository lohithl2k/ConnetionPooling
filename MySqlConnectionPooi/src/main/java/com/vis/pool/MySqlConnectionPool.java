package com.vis.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class MySqlConnectionPool{

	private static  BasicDataSource ds = new BasicDataSource();
	

static {	
	ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/demoDb?autoReconnect=true&useSSL=false");
    ds.setUsername("root");
    ds.setPassword("sHj@6378#jw"); 
    ds.setMinIdle(5);
    ds.setMaxIdle(10);
    ds.setMaxOpenPreparedStatements(100);  
}

public static Connection getConnection() throws SQLException {
	
	return ds.getConnection();
}	

public MySqlConnectionPool(){}

public void insert(int EmpID, String EmpName, int EmpAge, String EmpDept, String Email)
{
	String values="'"+EmpID+"'"+","+"'"+EmpName+"'"+","+"'"+EmpAge+"'"+","+"'"+EmpDept+"'"+",'"+Email+"'";
	String insertQuery="INSERT INTO DEMODB.EMPLOYEE VALUES("+values+");";
	
	System.out.println(insertQuery);
	
	try {
		//Context context =new InitialContext();
		//Object lookup = context.lookup(JNDI_LOOKUP_SERVICE);
		//if(lookup != null)
		//{
		//	dataSource = (DataSource)lookup;
		//}
		Connection con=MySqlConnectionPool.getConnection();
		PreparedStatement ps=con.prepareStatement(insertQuery);
		ps.executeUpdate();
		
		System.out.println("updated");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
}
public  void show()
{
	//String value;
	String showQuery="SELECT * FROM DEMODB.EMPLOYEE;";
	System.out.println(showQuery);
	

	try {
//		Statement stm=con.createStatement();
//		ResultSet rs=stm.executeQuery(showQuery);
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(showQuery);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void delete(int EmpID)
{
	int values=EmpID;
	String deleteQuery="DELETE FROM DEMODB.EMPLOYEE WHERE EMPID='"+values+"';";
	System.out.println(deleteQuery);
	
	try {
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(deleteQuery);
		ps.executeUpdate();
		

	} catch (SQLException e) {	
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Your acc delected sucessfully");	
}
public void update(String newEmail, String oldName)
{
	String query="UPDATE DEMODB.EMPLOYEE SET Email='"+newEmail+"' WHERE EMPNAME='"+oldName+"';";
	
	System.out.println(query);
	
	try {
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		System.out.println("updated Sucessfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
	

