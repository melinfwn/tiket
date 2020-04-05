package com.lawencon.tiketboot.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.CustomerDao;
import com.lawencon.tiketboot.model.Customer;

@Repository("customer_repo_jpa")
public class CustomerJPAImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public Customer insert(Customer customer) throws Exception {
		return repo.save(customer);
	}

	@Override
	public Customer update(Long id, String nama, String username, String password) throws Exception {
		List<Customer> list = new ArrayList<>();
		list = repo.findAllById(id);
		if (list != null) {
			Customer customer = list.get(0);
			customer.setNama(nama);
			customer.setUsername(username);
			customer.setPassword(password);
			repo.save(customer);
			return customer;
		}
		return null;
	}

	@Override
	public Customer delete(Long id) {
		 repo.deleteById(id);
		 return null;
	}

	@Override
	public List<Customer> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Customer> findById(Long id) {
		return repo.findAllById(id);
	}

	@Override
	public List<Customer> findByUsernamePassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}
