package com.lawencon.tiketboot.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.dao.TypeDao;
import com.lawencon.tiketboot.model.TypeTicket;
@Repository("type_repo_jpa")
public class TypeJPAImpl implements TypeDao{
	
	@Autowired
	private TypeRepo typeRepo;

	@Override
	public TypeTicket insertType(TypeTicket type) {
		return typeRepo.save(type);
	}

	@Override
	public TypeTicket updateType(Long id, String nama, int harga, String kategori) {
		List<TypeTicket> list = new ArrayList<>();
		list =typeRepo.findAllById(id);
		if (list != null) {
			TypeTicket type = list.get(0);
			type.setNama(nama);
			type.setKategori(kategori);
			type.setHarga(harga);
			return type;
		}
		return null;
	}

	@Override
	public void deleteType(Long id) {
		 typeRepo.deleteById(id);
	}

	@Override
	public List<TypeTicket> findAll() {
		return typeRepo.findAll();
	}

	@Override
	public List<TypeTicket> findById(Long id) {
		return typeRepo.findAllById(id);
	}

	@Override
	public Integer findHargaById(Long id) {
		return typeRepo.findHargaById(id);
	}

}
