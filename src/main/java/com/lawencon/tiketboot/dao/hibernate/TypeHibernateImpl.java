package com.lawencon.tiketboot.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.dao.TypeDao;
import com.lawencon.tiketboot.model.TypeTicket;

@Repository("type_repo_hibernate")
public class TypeHibernateImpl extends BaseHibernate implements TypeDao {

	@Override
	public TypeTicket insertType(TypeTicket type) {
		em.persist(type);
		return type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TypeTicket updateType(Long id, String nama, int harga, String kategori) {
		Query q = em.createQuery(" from TypeTicket where id = :idParam");
		q.setParameter("idParam", id);
		List<TypeTicket> typeList = new ArrayList<TypeTicket>();
		typeList = q.getResultList();
		TypeTicket type = new TypeTicket();
		type.setId(typeList.get(0).getId());
		type.setNama(nama);
		type.setKategori(kategori);
		type.setHarga(harga);
		em.merge(type);
		return type;
	}

	@Override
	public void deleteType(Long id) {
		Query q = em.createQuery(" from TypeTicket where id = :idParam");
		q.setParameter("idParam", id);
		TypeTicket type = new TypeTicket();
		type = (TypeTicket) q.getResultList();
		em.remove(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeTicket> findAll() {
		Query q = em.createQuery(" from TypeTicket");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeTicket> findById(Long id) {
		Query q = em.createQuery(" from TypeTicket where id = :idParam");
		q.setParameter("idParam", id);
		return q.getResultList();
	}

	@Override
	public Integer findHargaById(Long id) {
		Query q = em.createQuery("select u.harga from TypeTicket where id = :idParam").setParameter("idparam", id);
		TypeTicket type = new TypeTicket();
		type = (TypeTicket) q.getResultList();
		return type.getHarga();
		
	}

}
