package com.lawencon.tiketboot.dao;


import com.lawencon.tiketboot.model.Transaction;

public interface TransactionDao {

	abstract Transaction insert(Transaction transaction) throws Exception;

}
