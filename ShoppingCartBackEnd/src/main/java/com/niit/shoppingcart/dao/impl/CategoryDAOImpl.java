package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		// TODO Auto-generated constructor stub
	}

	public List<Category> list() {
		
		// select * from category -SQL query - mention the table name
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	@Transactional

	public boolean save(Category category) {

		try {
			// sessionFactory.getCurrentSession().save(category);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.saveOrUpdate(category);

			session.getTransaction().commit();
			session.close();
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(id);
			session.getTransaction().commit();
			session.close();
			
			return true;
		} catch (Exception e) {
			// e.printStackTrace();->it will print the exception in console
			// it will print package,class,method line number from which place
			e.printStackTrace();
			return false;
		}
	}

		public boolean deletebyname(String name) {
			try {
				sessionFactory.getCurrentSession().delete(getCategoryByID(name));
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				session.delete(name);
				session.getTransaction().commit();
				session.close();
				
				return true;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return false;
			}
	}

	public boolean delete(Category category) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();

			return true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryByID(String id) {
		// get method means ->select * from Category where id=?
		// return (Category)
		// sessionFactory.getCurrentSession().get(Category.class, id);
		// here get method is excepting a class
		// we can write query also as below here + is concatenation
		// 1->sessionFactory.getCurrentSession().createQuery("from Category
		// where id= '"+id+"'" ).list().get(0);
		// 1st or 2nd query meaning same
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where id= '" + id + "'")
				.uniqueResult();
	}

	public Category getCategoryBYName(String name) {

		// here based on name we are fetching the record
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name= '" + name + "'")
				.list().get(0);
	}

}
