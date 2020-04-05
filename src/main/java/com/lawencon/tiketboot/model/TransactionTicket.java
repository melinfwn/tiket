package com.lawencon.tiketboot.model;

import java.util.List;

public class TransactionTicket {

	private Transaction transaction;
	private List<TicketPesanan> ticket;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<TicketPesanan> getTicket() {
		return ticket;
	}

	public void setTicket(List<TicketPesanan> ticket) {
		this.ticket = ticket;
	}

}
