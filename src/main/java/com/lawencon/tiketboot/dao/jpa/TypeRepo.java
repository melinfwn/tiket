package com.lawencon.tiketboot.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.tiketboot.model.TypeTicket;
@Repository
public interface TypeRepo extends JpaRepository<TypeTicket, Long> {
	List<TypeTicket> findAllById(Long id);
	Integer findHargaById(Long id);
}
