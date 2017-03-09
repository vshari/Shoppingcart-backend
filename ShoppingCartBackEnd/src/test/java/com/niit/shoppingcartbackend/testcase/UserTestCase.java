package com.niit.shoppingcartbackend.testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void initilize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		
		context.refresh();
		user = (User)context.getBean("user");
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	@Test
	public void validateCredentialsTestCase()
	{
		boolean flag = userDAO.validate("17", "hari");
		assertEquals("validateCredentialsTestCase",true,flag);
	}
	

}
