package com.vis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

//import com.mysql.cj.xdevapi.PreparableStatement;



public class Database {
  
	String dbUrl="jdbc:mysql://localhost:3306/demoDB";
	String dbUser="root";
	String dbpass="sHj@6378#jw";
	
	Connection con;
	
	public void connect()
	{
		try {
			con=DriverManager.getConnection(dbUrl,dbUser,dbpass);
			System.out.println("Connected to mysql");
			DataSource obl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insert(int EmpID, String EmpName, int EmpAge, String EmpDept)
	{
		String values="'"+EmpID+"'"+","+"'"+EmpName+"'"+","+"'"+EmpAge+"'"+","+"'"+EmpDept+"'";
		String insertQuery="INSERT INTO DEMODB.EMPLOYEE VALUES ("+values+");";
		
		System.out.println(insertQuery);
		
		connect();
		Statement stm;
		try {
			stm = con.createStatement();
			stm.executeUpdate(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("updated");
		disconnect();
		
	}
	public void delete(int EmpID)
	{
		int values=EmpID;
		String deleteQuery="DELETE FROM DEMODB.EMPLOYEE WHERE EMPID='"+values+"';";
		System.out.println(deleteQuery);
		connect();
		try {
			PreparedStatement ps=con.prepareStatement(deleteQuery);
			ps.executeUpdate();
			
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your acc delected sucessfully");
	//	disconnect();
		
		
	}
	public void update(String newName, String oldName)
	{
		String query="UPDATE DEMODB.EMPLOYEE SET EMPNAME='"+newName+"' WHERE EMPNAME='"+oldName+"';";
		connect();
		System.out.println(query);
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect();
		
		
	}
	public void selectOne(int EmpId)
	{
		String selectQuery="SELECT EMPNAME FROM DEMODB.EMPLOYEE WHERE EMPID='"+EmpId+"';";
		System.out.println(selectQuery);
		connect();
		
		
		try {
		     Statement stm=con.createStatement();
		     ResultSet rs=stm.executeQuery(selectQuery);
		     
		     rs.next();
		    
		    // int empid=rs.getInt("EmpID");
		     String empname=rs.getString("EmpName");
		   //  int empage=rs.getInt("EmpAge");
		   //  String empdept=rs.getString("EmpDept");
		     
		   //  System.out.println("EmpID="+empid+", EmpName ="+empname+", EmpAge ="+empage+", EmpDep ="+empdept);
		     System.out.println("EMPNAME ="+empname);
		     disconnect();
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public void show()
	{
		//String value;
		String showQuery="SELECT * FROM DEMODB.EMPLOYEE;";
		System.out.println(showQuery);
		connect();

		try {
//			Statement stm=con.createStatement();
//			ResultSet rs=stm.executeQuery(showQuery);
			PreparedStatement ps=con.prepareStatement(showQuery);
			ResultSet rs=ps.executeQuery();
			
			
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Your profile");
		disconnect();
		
	}
	public void disconnect()
	{
		try {
			con.close();
			System.out.println("disconnected from sql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

