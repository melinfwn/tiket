package com.lawencon.tiketboot.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.dao.CustomerDao;
import com.lawencon.tiketboot.model.Customer;

@Repository("customer_repo_hibernate")
public class CustomerHibernateImpl extends BaseHibernate implements CustomerDao {

	@Override
	public Customer insert(Customer customer) throws Exception {
		em.persist(customer);
		return customer;
	}

	Customer customer = new Customer();

	@SuppressWarnings("unchecked")
	@Override
	public Customer update(Long id, String nama, String username, String password) throws Exception {
		Query q = em.createQuery(" from Customer where id = :idParam").setParameter("idParam", id);
		List<Customer> list = new ArrayList<Customer>();
		list = q.getResultList();
		customer.setId(list.get(0).getId());
		customer.setNama(nama);
		customer.setUsername(username);
		customer.setPassword(password);
		em.merge(customer);
		return customer;
	}

	@Override
	public Customer delete(Long id) {
		Query q = em.createQuery(" from Customer where id = :idParam").setParameter("idParam", id);
		customer = (Customer) q.getResultList();
		em.remove(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		Query q = em.createQuery(" from Customer");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findById(Long id) {
		Query q = em.createQuery(" from Customer where id = :idParam").setParameter("idParam", id);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByUsernamePassword(String username, String password) {
		Query q = em.createQuery(" from Customer where username = :userParam and password = :passParam")
				.setParameter("userParam", username).setParameter("passParam", password);
		return q.getResultList();
	}

}
