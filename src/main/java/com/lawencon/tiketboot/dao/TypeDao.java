package com.lawencon.tiketboot.dao;

import java.util.List;

import com.lawencon.tiketboot.model.TypeTicket;

public interface TypeDao {
	abstract TypeTicket insertType(TypeTicket type);

	abstract TypeTicket updateType(Long id, String nama, int harga, String kategori);

	abstract void deleteType(Long id);

	abstract List<TypeTicket> findAll();

	abstract List<TypeTicket> findById(Long id);
	
	abstract Integer findHargaById(Long id);
}
