package com.lawencon.tiketboot.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.tiketboot.dao.CustomerDao;
import com.lawencon.tiketboot.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("customer_repo_hibernate")
	private CustomerDao customerService;

	@Override
	public Customer insert(Customer customer) throws Exception {
		return customerService.insert(customer);
	}

	@Override
	public Customer update(Long id, Customer customer) throws Exception {
		return customerService.update(id, customer.getNama(), customer.getUsername(), customer.getPassword());
	}

	@Override
	public Customer delete(Long id) {
		return customerService.delete(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@Override
	public List<Customer> findById(Long id) {
		return customerService.findById(id);
	}

	@Override
	public List<Customer> findByUsernamePassword(String username, String password) {
		return customerService.findByUsernamePassword(username, password);
	}

}
