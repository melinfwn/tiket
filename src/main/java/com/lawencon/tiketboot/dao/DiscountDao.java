package com.lawencon.tiketboot.dao;

import java.util.List;

import com.lawencon.tiketboot.model.Discount;

public interface DiscountDao {
	abstract Discount insert(Discount discount) throws Exception;

	abstract Discount update(Long id, String kode, int potongan) throws Exception;

	abstract void delete(Long id) throws Exception;

	abstract List<Discount> findAll() throws Exception;

	abstract Discount findByKodeVoucher(String kode) throws Exception;
	
	abstract Integer getDiscount(String kode);

}
