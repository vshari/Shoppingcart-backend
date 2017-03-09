package com.niit.shoppingcartbackend.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	static CategoryDAO categoryDAO;

	// @BeforeClass it should be static

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	// WRITE TEST CASES we required test cases for create,update,delete and
	// create new category
	@Test
   
	public void saveCategoryTestCase() {
		category.setId("111");
		category.setName("abcd");
		category.setDescription("this is my usn number");
		boolean flag = categoryDAO.save(category);
		Assert.assertEquals("saveCategoryTestCase", true, flag);

	}

	public void updateCategoryTestCase() {
		category.setId("124");
		category.setName("kitty");
		category.setDescription("updating my description");
		boolean flag = categoryDAO.update(category);
		Assert.assertEquals("updateCategoryTestCase", true, flag);

	}
	
	 
	public void deleteCategoryTestCase() {
		category.setId("108");
		category.setName("noname");
		category.setDescription("deleting my usn number");
		boolean flag = categoryDAO.delete(category);
		Assert.assertEquals("deleteCategoryTestCase", true, flag);

	}
	
	public void deletebyidCategoryTestCase() {
		category.setId("108");
		// category.setName("kitty");
		category.setDescription("deleting my usn number by id");
		boolean flag = categoryDAO.delete(category);
		Assert.assertEquals("deletebyidCategoryTestCase", true, flag);
	}

	/*DEEPSIR CODE
	  @Test public void createCategoryTestCase() { category.setId("8");
	  category.setName("Mobile Category"); category.setDescription(
	  "This is mobile category"); boolean flag = categoryDAO.save(category);
	  
	  // compare what you are excepting verses what you are getting from save
	  // method // to compare v have asserts methods
	  Assert.assertEquals("createCategoryTestCase", true, flag);
	  
	  }
	  
	  @Test public void deleteCategoryTestCase() { Category category =
	  (Category) categoryDAO.getCategoryBYName("nokia"); boolean flag =
	  categoryDAO.delete(category); Assert.assertEquals(true, flag); }
	 

	// getting error for delete by name
	
	  @Test public void deletebynameCategoryTestCase(){
	  //category.setId("124"); category.setName("noname");
	  //category.setDescription("deleting my usn number by id"); boolean
	  flag=categoryDAO.delete(category);
	  Assert.assertEquals("deletebynameCategoryTestCase",true,flag); }
	 
	  @Test 
	  public void updateCategoryTestCase() { 
		  Category category = (Category) categoryDAO.getCategoryByID("7"); 
	 category.setDescription("This is chNGED DESC***"); 
	  Assert.assertEquals(true, categoryDAO.update(category));
	  
	  }*/
	 

}
