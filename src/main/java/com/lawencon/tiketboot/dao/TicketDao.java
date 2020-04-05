package com.lawencon.tiketboot.dao;

import java.util.List;
import com.lawencon.tiketboot.model.TicketPesanan;

public interface TicketDao {

	abstract TicketPesanan insert(TicketPesanan ticket);
	abstract List<TicketPesanan> findAll();
	abstract List<TicketPesanan> findById(Long id);
}
