package com.lawencon.tiketboot.dao.hibernate;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.TicketDao;
import com.lawencon.tiketboot.model.TicketPesanan;

@Repository("ticket_repo_hibernate")
public class TicketHibernateImpl extends BaseHibernate implements TicketDao {

	TicketPesanan ticket = new TicketPesanan();

	// PIKIRKAN LAGI
	@Override
	public TicketPesanan insert(TicketPesanan ticket) {
		em.persist(ticket);
		return ticket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketPesanan> findAll() {
		Query q = em.createQuery(
				"select t.nama as namaPenumpang, t.tglBerangkat as waktuBerangkat, t.kursi as kursi, ty.nama as namaAngkutan, ty.kategori as kategori, ty.harga as harga from TicketPesanan t left join t.type ty");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketPesanan> findById(Long id) {
		Query q = em.createQuery(
				"select trans.id, t.nama, t.tglBerangkat, t.kursi, ty.nama, ty. kategori, ty.harga from TicketPesanan t left join t.type ty inner join t.transaction trans where trans.id = :idParam")
				.setParameter("idParam", id);
		return q.getResultList();

	}
	
	

}
