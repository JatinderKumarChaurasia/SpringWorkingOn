package com.jkc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jkc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		// for this we need to bind the id to customer-form using <form:hidden path="id"/>
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		System.out.println(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> deleteCustomer = session.createQuery("delete from Customer where id=:customerId",Customer.class);
		deleteCustomer.setParameter("customerId", id);
		deleteCustomer.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = null;
		if(name != null && name.trim().length() >0){
			query = session.createQuery("from Customer where lower(firstName) like :customerName or lower(lastName) like :customerName",Customer.class);
			query.setParameter("customerName", name);
			
		}else{
			query = session.createQuery("from Customer",Customer.class);
		}
		List<Customer> customers = query.getResultList();
		return customers;
	}
}
