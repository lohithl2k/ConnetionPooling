package com.vis.pool;

import java.util.Scanner;

public class MainClasspool {

	public static void select(int option)
	{
	     MySqlConnectionPool ms=new MySqlConnectionPool();
		 Service se=new Service();
		switch (option){
		case 1:  se.signup();
		break;
		case 2:  ms.show();
		break;
		case 3:  se.deleteAcc();
		break;
		case 4:  se.editprof();
		break;
		default : System.out.println("Inavalid input");
		}
	}
	public static void main(String[] args){
	
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER 1 FOR SIGNUP");
		System.out.println("ENTER 2 FOR SHOW TABLE DETAILS");
		System.out.println("ENTER 3 FOR DELET PROFILE");
		System.out.println("ENTER 4 FOR UPATE PROFILE");
		int option=sc1.nextInt();
        MainClasspool.select(option);
         
	}
}