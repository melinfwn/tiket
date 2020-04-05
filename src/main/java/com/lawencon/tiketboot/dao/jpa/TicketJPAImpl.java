package com.lawencon.tiketboot.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.TicketDao;
import com.lawencon.tiketboot.model.TicketPesanan;

@Repository("ticket_repo_jpa")
public class TicketJPAImpl implements TicketDao {

	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public TicketPesanan insert(TicketPesanan ticket) {
		return ticketRepo.save(ticket);
	}


	@Query("select t.nama as nama_penumpang, t.tgl_berangkat as waktu_berangkat, t.kursi as kursi, ty.nama as nama_angkutan, ty.kategori as kategori, ty.harga as harga from ticket_pesanan t left join t.type ty")
	@Override
	public List<TicketPesanan> findAll() {
		return ticketRepo.findAll();
	}

	@Query("select trans.id, t.nama, t.tgl_berangkat, t.kursi, ty.nama, ty. kategori, ty.harga from ticket_pesanan t left join t.type ty inner join t.transaction trans where trans.id = ?1")
	@Override
	public List<TicketPesanan> findById(Long id) {
		return ticketRepo.findAllById(id);
	}

}
