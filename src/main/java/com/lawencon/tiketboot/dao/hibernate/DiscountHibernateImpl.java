package com.lawencon.tiketboot.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.tiketboot.dao.DiscountDao;
import com.lawencon.tiketboot.model.Discount;

@Repository("discount_repo_hibernate")
public class DiscountHibernateImpl extends BaseHibernate implements DiscountDao {

	@Override
	public Discount insert(Discount discount) throws Exception {
		em.persist(discount);
		return discount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Discount update(Long id, String kode, int potongan) throws Exception {
		Query q = em.createQuery(" from Discount where id = :idParam");
		q.setParameter("idParam", id);
		List<Discount> list = new ArrayList<Discount>();
		Discount discount = new Discount();
		list = q.getResultList();
		discount.setId(list.get(0).getId());
		discount.setKodeVoucher(kode);
		discount.setPotonganHarga(potongan);
		em.merge(discount);
		return discount;
	}

	@Override
	public void delete(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where id = :idParam");
		q.setParameter("idParam", id);
		Discount discount = new Discount();
		discount = (Discount) q.getResultList();
		em.remove(discount);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> findAll() throws Exception {
		Query q = em.createQuery(" from Discount");
		return q.getResultList();
	}

	@Override
	public Discount findByKodeVoucher(String kode) throws Exception {
		Query q = em.createQuery(" from Discount where kodeVoucher = :kodeParam");
		q.setParameter("kodeParam", kode);
		Discount discount = (Discount) q.getResultList();
		return discount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getDiscount(String kode) {
		Query q = em.createQuery("from Discount where kodeVoucher = :kodeParam").setParameter("kodeParam", kode);
		List<Discount> list = q.getResultList();
		if (list.get(0) != null) {
			Integer potongan = list.get(0).getPotonganHarga();
			return potongan;
		}
		return 0;
	}

}
