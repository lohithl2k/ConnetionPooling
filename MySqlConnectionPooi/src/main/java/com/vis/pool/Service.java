package com.vis.pool;

import java.util.Scanner;

public class Service {

	 Scanner sc=new Scanner(System.in);
	 MySqlConnectionPool ms=new MySqlConnectionPool();		
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
				
				System.out.println("enter mailid");
				String Email=sc.next();
				
				ms.insert(EmpId, EmpName, EmpAge, EmpDept, Email);			
			}
			
			public void deleteAcc() {
				System.out.println("enter your id");
				int EmpID=sc.nextInt();
				
				ms.delete(EmpID);
			}
			public void editprof()
			{
				System.out.println("Enter your email");
				String NewEmail=sc.next();
				System.out.println("enter your name");
				String empName=sc.next();
				
				ms.update(NewEmail, empName);
				
			}
		}

