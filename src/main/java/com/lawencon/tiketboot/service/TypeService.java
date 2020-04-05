package com.lawencon.tiketboot.service;

import java.util.List;

import com.lawencon.tiketboot.model.TypeTicket;

public interface TypeService {

	abstract TypeTicket insertType(TypeTicket type);

	abstract TypeTicket updateType(Long id, String nama, int harga, String kategori);

	abstract void deleteType(Long id);

	abstract List<TypeTicket> findAll();

	abstract List<TypeTicket> findById(Long id);
}
