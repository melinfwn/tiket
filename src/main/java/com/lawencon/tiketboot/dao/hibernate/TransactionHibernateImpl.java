package com.lawencon.tiketboot.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.TransactionDao;
import com.lawencon.tiketboot.model.Transaction;

@Repository("transaction_repo_hibernate")
public class TransactionHibernateImpl extends BaseHibernate implements TransactionDao {

	Transaction transaction = new Transaction();

	@Override
	public Transaction insert(Transaction transaction) throws Exception {
		em.persist(transaction);
		return transaction;
	}


}
