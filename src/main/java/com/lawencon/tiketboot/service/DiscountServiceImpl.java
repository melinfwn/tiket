package com.lawencon.tiketboot.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.tiketboot.dao.DiscountDao;
import com.lawencon.tiketboot.model.Discount;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	@Qualifier("discount_repo_jpa")
	private DiscountDao discountService;

	@Override
	public Discount insert(Discount discount) throws Exception {
		return discountService.insert(discount);
	}

	@Override
	public Discount update(Long id, String kode, int potongan) throws Exception {
		return discountService.update(id, kode, potongan);
	}

	@Override
	public void delete(Long id) throws Exception {
		 discountService.delete(id);
	}

	@Override
	public List<Discount> findAll() throws Exception {
		return discountService.findAll();
	}

	@Override
	public Discount findByKodeVoucher(String kode) throws Exception {
		return discountService.findByKodeVoucher(kode);
	}

	@Override
	public Integer getDiscount(String kode) {
		return discountService.getDiscount(kode);
	}

}
