package com.vis.jdbc;

import java.util.Scanner;

public class UserService {
	//private static final String EmpID = null;
	Scanner sc=new Scanner(System.in);
	public void signup()
	{
		System.out.println("enter id");
		int EmpId=sc.nextInt();
		
		System.out.println("enter name");
		String EmpName=sc.next();
		
		System.out.println("enter age");
		int EmpAge=sc.nextInt();
		
		System.out.println("enter EmpDEpt");
		String EmpDept=sc.next();
		
		Database db=new Database();
		db.insert(EmpId, EmpName, EmpAge, EmpDept);
		
	}
	public void deletemyacc()
	{
		System.out.println("enter your id");
		int EmpID=sc.nextInt();
		
		
		Database db1=new Database();
		db1.delete(EmpID);
		
		
	}
	public void editprofile()
	{
	    System.out.println("enter your newName");
	    String newName=sc.next();
	    System.out.println("Enter your oldName");
	    String oldName=sc.next();
	    
	    Database ds=new Database();
	    ds.update(newName, oldName);
		
	}
	public void viewprofile()
	{
		System.out.println("enter your id");
		
		int EmpId=sc.nextInt();
		//System.out.println("enter name");
		//String EmpName=sc.next();
		
		Database db=new Database();
		db.selectOne(EmpId);
		
		}
	public void showmyprof()
	{
		System.out.println("enter yor id");
		int Empid=sc.nextInt();
		Database db=new Database();
		db.selectOne(Empid);
		
	}
}
