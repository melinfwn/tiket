package com.lawencon.tiketboot.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.model.Discount;
@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
	Discount findByKodeVoucher(String kode);
	List<Discount> findAllById(Long id);
	List<Discount> findPotonganHargaByKodeVoucher(String kode);

}
