package com.lawencon.tiketboot.service;

import java.util.List;

import com.lawencon.tiketboot.model.TicketPesanan;
import com.lawencon.tiketboot.model.TransactionTicket;

public interface TicketTransactionService {
	abstract TransactionTicket insertTransTicket(TransactionTicket trans, String username, String password,String kodeDiskon)
			throws Exception;
	abstract TicketPesanan insert(TicketPesanan ticket);

	abstract List<TicketPesanan> findAll(String username, String password);

	abstract List<TicketPesanan> findById(Long id,String username, String password);

}
