package com.lawencon.tiketboot.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.tiketboot.dao.TypeDao;
import com.lawencon.tiketboot.model.TypeTicket;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	@Qualifier("type_repo_hibernate")
	private TypeDao typeService;

	@Override
	public TypeTicket insertType(TypeTicket type) {
		return typeService.insertType(type);
	}

	@Override
	public TypeTicket updateType(Long id, String nama, int harga, String kategori) {
		return typeService.updateType(id, nama, harga, kategori);
	}

	@Override
	public void deleteType(Long id) {
		 typeService.deleteType(id);
	}

	@Override
	public List<TypeTicket> findAll() {
		return typeService.findAll();
	}

	@Override
	public List<TypeTicket> findById(Long id) {
		return typeService.findById(id);
	}

}
