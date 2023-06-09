package org.jsp.userappspring.controller;

import java.util.Scanner;

import org.jsp.userappspring.UserConfig;
import org.jsp.userappspring.dao.UserDao;
import org.jsp.userappspring.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController 
{
     static Scanner sc=new Scanner(System.in);	
     static UserDao dao;
     static {
    	 ApplicationContext context=new AnnotationConfigApplicationContext(UserConfig.class);
 		dao=context.getBean(UserDao.class);
     }
	 public static void main(String[] args) 
	 {
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Delete User");
		System.out.println("4.Verify User with phone and password");
		System.out.println("5.verify User with email and password");
		System.out.println("6.Verify User with id and password");
		
		switch(sc.nextInt())
		{
		case 1:
			save();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			verify();
			break;
		case 5:
			verify1();
			break;
		case 6:
			verify2();
			break;
		}
	 }
	 
	 public static void save()
	 {
		 System.out.println("Enter user name,phone,email and password");
		 String name=sc.next();
		 long phone=sc.nextLong();
		 String email=sc.next();
		 String password=sc.next();
		 User u=new User();
		 u.setName(name);
		 u.setPhone(phone);
		 u.setEmail(email);
		 u.setPassword(password);
		 u=dao.saveUser(u);
		 System.out.println("User saved with id :- "+u.getId());
				 
	 }
	 
	 public static void update()
	 {
		 System.out.println("Enter user is to update");
		 int id=sc.nextInt();
         
		 System.out.println("Enter user name,phone,email and password");
		 String name=sc.next();
		 long phone=sc.nextLong();
		 String email=sc.next();
		 String password=sc.next();
		 User u=new User();
		 u.setId(id);
		 u.setName(name);
		 u.setPhone(phone);
		 u.setEmail(email);
		 u.setPassword(password);
		 u=dao.updateUser(u);
		 System.out.println("User Update with id :- "+u.getId());
	 }
	 
	 public static void verify()
	 {
		 System.out.println("Enter user phone and password to verify");
		 long phone=sc.nextLong();
		 String password=sc.next();
		 
		 User u=new User();
		 u=dao.verifyUser(phone, password);
		 if(u!=null)
		 {
			 System.out.println("User_id :- "+u.getId());
			 System.out.println("User_name :- "+u.getName());
			 System.out.println("User_phone :- "+u.getPhone());
			 System.out.println("User_email :- "+u.getEmail());
		 }
		 else
		 {
			 System.err.println("You entered wrong phone and password");
		 }
	 }
	 
	 public static void delete()
	 {
		 System.out.println("Enter User_Id To Delete");
		 int id=sc.nextInt();
		 boolean b=dao.deleteUser(id);
		 if(b)
		 {
			 System.out.println("User Deleted !!! ");
		 }
		 else
		 {
			 System.out.println("You entered wrong user_id");
		 }
	 }
	 
	 public static void verify1()
	 {
		 System.out.println("Enter user email and password to verify");
		 String email=sc.next();
		 String password=sc.next();
		 
		 User u=new User();
		 u=dao.verifyUser(email, password);
		 if(u!=null)
		 {
			 System.out.println("User_id :- "+u.getId());
			 System.out.println("User_name :- "+u.getName());
			 System.out.println("User_phone :- "+u.getPhone());
			 System.out.println("User_email :- "+u.getEmail());
		 }
		 else
		 {
			 System.err.println("You entered wrong phone and password");
		 }
	 }
	 
	 public static void verify2()
	 {
		 System.out.println("Enter User id and password to verify");
		 int id=sc.nextInt();
		 String password=sc.next();
		 
		 User u=new User();
		 u=dao.verifyUser(id, password);
		 if(u!=null)
		 {
			 System.out.println("User_id :- "+u.getId());
			 System.out.println("User_name :- "+u.getName());
			 System.out.println("User_phone :- "+u.getPhone());
			 System.out.println("User_email :- "+u.getEmail());
		 }
		 else
		 {
			 System.err.println("You entered wrong phone and password");
		 }
	 }
}
