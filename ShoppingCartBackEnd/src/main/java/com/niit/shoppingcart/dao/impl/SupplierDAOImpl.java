package com.niit.shoppingcart.dao.impl;



import java.util.List;



import javax.transaction.Transactional;



import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import com.niit.shoppingcart.dao.SupplierDAO;



import com.niit.shoppingcart.domain.Supplier;





@Transactional

@Repository("supplierDAO")



public class SupplierDAOImpl implements SupplierDAO {



@Autowired

private SessionFactory sessionFactory;



private Session getSession() {

return sessionFactory.getCurrentSession();

}


public List<Supplier> list() {

return getSession().createQuery("from Supplier").list();

}



/*public Supplier getUser(String id) {

return (Supplier) getSession().get(Supplier.class, id);

}*/



public boolean save(Supplier supplier) {

try {



// sessionFactory.getCurrentSession().save(supplier);

Session session = sessionFactory.openSession();

session.beginTransaction();

session.save(supplier);

session.getTransaction().commit();

session.close();

return true;

} catch (Exception e) {

e.printStackTrace();

return false;

}



}



public boolean update(Supplier supplier) {


try {

Session session = sessionFactory.openSession();

session.beginTransaction();

session.saveOrUpdate(supplier);

session.getTransaction().commit();

session.close();

return true;

} catch (Exception e) {

// TODO Auto-generated catch block

e.printStackTrace();

return false;

}

}




public boolean delete(Supplier supplier) {

// TODO Auto-generated method stub

return false;

}



public Supplier getSupplier(String id) {

// TODO Auto-generated method stub

return null;

}


}







