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
import com.lawencon.tiketboot.model.Customer;
import com.lawencon.tiketboot.service.CustomerService;

@RestController
public class CostumerController extends BaseController {

	@Autowired
	private CustomerService customerService;

	Customer customer = new Customer();
	List<Customer> list = new ArrayList<Customer>();

	@PostMapping("customer/insert")
	public ResponseEntity<Customer> insertCustomer(@RequestBody String content) {
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.insert(customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("customer/update")
	public ResponseEntity<Customer> updateCustomer(@RequestParam("id") Long id, @RequestBody String content) {
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.update(id, customer);
			return new ResponseEntity<>(customer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("customer/delete")
	public ResponseEntity<String> deleteCustomer(@RequestParam("id") Long id) {
		try {
			customerService.delete(id);
			return new ResponseEntity<>("Berhasil Hapus", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Hapus", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("customer/findall")
	public ResponseEntity<List<Customer>> findAllCustomer() {
		try {
			list = customerService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("customer/findbyid")
	public ResponseEntity<List<Customer>> findCustomerById(@RequestParam("id") Long id) {
		try {
			list = customerService.findById(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
}
