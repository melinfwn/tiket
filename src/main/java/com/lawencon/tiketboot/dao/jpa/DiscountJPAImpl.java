package com.lawencon.tiketboot.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.dao.DiscountDao;
import com.lawencon.tiketboot.model.Discount;

@Repository("discount_repo_jpa")
public class DiscountJPAImpl implements DiscountDao {

	@Autowired
	private DiscountRepo discountRepo;

	@Override
	public Discount insert(Discount discount) throws Exception {
		return discountRepo.save(discount);
	}

	@Override
	public Discount update(Long id, String kode, int potongan) throws Exception {
		List<Discount> list = new ArrayList<Discount>();
		list = discountRepo.findAllById(id);
		if (list != null) {
			Discount discount = list.get(0);
			discount.setKodeVoucher(kode);
			discount.setPotonganHarga(potongan);
			return discountRepo.save(discount);
		}
		return null;
	}

	@Override
	public void delete(Long id) throws Exception {
		discountRepo.deleteById(id);
		;
	}

	@Override
	public List<Discount> findAll() throws Exception {
		return discountRepo.findAll();
	}

	@Override
	public Discount findByKodeVoucher(String kode) throws Exception {
		return discountRepo.findByKodeVoucher(kode);
	}

	@Override
	public Integer getDiscount(String kode) {
		List<Discount> list = discountRepo.findPotonganHargaByKodeVoucher(kode);
		Integer potongan = list.get(0).getPotonganHarga();
		return potongan;
	}

}
