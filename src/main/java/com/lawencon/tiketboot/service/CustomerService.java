package com.lawencon.tiketboot.service;

import java.util.List;

import com.lawencon.tiketboot.model.Customer;

public interface CustomerService {

	abstract Customer insert(Customer customer) throws Exception;
	abstract Customer update(Long id, Customer customer) throws Exception;
	abstract Customer delete(Long id);
	abstract List<Customer> findAll();
	abstract List<Customer> findById(Long id);
	abstract List<Customer> findByUsernamePassword(String username, String password);
}
