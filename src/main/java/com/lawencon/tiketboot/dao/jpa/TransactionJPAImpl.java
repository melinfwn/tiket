package com.lawencon.tiketboot.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.TransactionDao;
import com.lawencon.tiketboot.model.Transaction;
@Repository("transaction_repo_jpa")
public class TransactionJPAImpl implements TransactionDao{
	
	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public Transaction insert(Transaction transaction) throws Exception {
		return transactionRepo.save(transaction);
	}

}
