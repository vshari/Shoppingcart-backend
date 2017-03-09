package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {

	// get all categories
	public List<Category> list();

	// create category
	public boolean save(Category category);

	// update category
	public boolean update(Category category);
	
	//delete category by id
	public boolean delete(String id);
	//delete category by name
		public boolean deletebyname(String name);

	// delete category by category
	public boolean delete(Category category);

	// get category by id
	public Category getCategoryByID(String id);

	// get category by name
	public Category getCategoryBYName(String name);

}
