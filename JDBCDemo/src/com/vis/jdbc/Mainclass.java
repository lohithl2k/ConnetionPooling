package com.vis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mainclass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
          String dbUrl="jdbc:mysql://localhost:3306/demoDB";
          String dbUser="root";
          String dbpass="sHj@6378#jw";
          
          Connection con=null;
          
          try {
			con=DriverManager.getConnection(dbUrl, dbUser, dbpass);
			System.out.println("connected to mysql");
		} 
          catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          
          try {
			con.close();
			System.out.println("disconnect from mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          
          
	}

}
