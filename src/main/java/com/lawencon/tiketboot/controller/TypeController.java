package com.lawencon.tiketboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiketboot.model.TypeTicket;
import com.lawencon.tiketboot.service.TypeService;

@RestController
public class TypeController extends BaseController {

	@Autowired
	private TypeService typeService;
	
	TypeTicket type = new TypeTicket();
	
	List<TypeTicket> list = new ArrayList<TypeTicket>();

	@PostMapping("type/insert")
	public ResponseEntity<TypeTicket> insertType(@RequestBody String content) {
		try {
			type = new ObjectMapper().readValue(content, TypeTicket.class);
			typeService.insertType(type);
			return new ResponseEntity<>(type, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(type, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("type/update")
	public ResponseEntity<TypeTicket> updateType(@RequestParam("id") Long id,@RequestBody String content){
		try {
			type = new ObjectMapper().readValue(content, TypeTicket.class);
			typeService.updateType(id, type.getNama(), type.getHarga(), type.getKategori());
			return new ResponseEntity<>(type,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(type, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("type/delete")
	public ResponseEntity<String> deleteType(@RequestParam("id") Long id){
		try {
			typeService.deleteType(id);
			return new ResponseEntity<>("Berhasil hapus",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal hapus", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("type/findall")
	public ResponseEntity<List<TypeTicket>> findAllType(){
		try {
			list = typeService.findAll();
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("type/findbyid")
	public ResponseEntity<List<TypeTicket>> findTypeById(@RequestParam("id") Long id){
		try {
			list = typeService.findById(id);
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
}
