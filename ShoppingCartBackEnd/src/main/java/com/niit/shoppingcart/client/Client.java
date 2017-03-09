package com.niit.shoppingcart.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.ApplicationContextConfig;
import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.domain.Category;

public class Client {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

		CategoryDAO cdao = (CategoryDAO) ctx.getBean("CategoryDAO");

		Category category = new Category();
		category.setId("1");
		category.setName("nokia");
		category.setDescription("lumia720");

		if (cdao.save(category)) {

			System.out.println("it is saved");
		}

		else {

			System.out.println("Not saved..");
		}

	}

}