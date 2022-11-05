package com.springboot.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	JdbcTemplate jTemp;
	
	@Autowired
	NamedParameterJdbcTemplate nameParameterJTemp;

	@Override
	public void addCustomer(Customer cus) {
		String SQL = "insert into mycustomers value(?,?,?,?,?)";
		jTemp.update(SQL, cus.getCid(), cus.getCname(), cus.getEmail(), cus.getPhone(), cus.getCity());
		
	}

	@Override
	public void addCustomer1(Customer cus) {
		String SQL = "insert into mycustomers value(:cid,:cname,:email,:phone,:city)";
		Map<String,Object> map = new HashMap<>();
		map.put("cid", cus.getCid());
		map.put("cname", cus.getCname());
		map.put("email", cus.getEmail());
		map.put("phone", cus.getPhone());
		map.put("city", cus.getCity());
		nameParameterJTemp.update(SQL, map);
		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		String SQL = "select * from mycustomers";
		List<Customer> myList = jTemp.query(SQL, new CustomerRowMapper());
		return myList;
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		String SQL = "select * from mycustomers where city=?";
		List<Customer> myList = jTemp.query(SQL, new CustomerRowMapper(), city);
		return myList;
	}

	@Override
	public List<Customer> getAllCustomers1() {
		String SQL = "select * from mycustomers";
		List<Customer> myList = nameParameterJTemp.query(SQL, new CustomerRowMapper());
		return myList;
	}

}
