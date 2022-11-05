package com.springboot.jdbc;

import java.util.List;

public interface CustomerDAO {

	public void addCustomer(Customer cus);
	public List<Customer> getAllCustomers();
	public List<Customer> getAllCustomers1();
	public List<Customer> getCustomerByCity(String city);
	public void addCustomer1(Customer cus);
}
