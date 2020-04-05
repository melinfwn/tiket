package com.lawencon.tiketboot.dao.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	List<Customer> findByUsernameAndPassword(String username, String password);
	List<Customer> findAllById(Long id);

}
