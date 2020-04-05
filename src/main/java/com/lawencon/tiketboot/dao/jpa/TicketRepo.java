package com.lawencon.tiketboot.dao.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.model.TicketPesanan;
@Repository
public interface TicketRepo extends JpaRepository<TicketPesanan, Long>{
	
	List<TicketPesanan> findAllById(Long id);

	List<TicketPesanan> findAll();
}
