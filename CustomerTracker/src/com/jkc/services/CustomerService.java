package com.jkc.services;

import java.util.List;

import com.jkc.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String name);
}
