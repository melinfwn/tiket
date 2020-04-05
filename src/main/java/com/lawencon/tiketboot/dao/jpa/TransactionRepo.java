package com.lawencon.tiketboot.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.model.Transaction;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{
	List<Transaction> findAllById(Long id);
}
