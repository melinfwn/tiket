package com.lawencon.tiketboot.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiketboot.model.TicketPesanan;
import com.lawencon.tiketboot.model.TransactionTicket;
import com.lawencon.tiketboot.service.TicketTransactionService;

@RestController
public class TicketTransactionController extends BaseController {

	@Autowired
	private TicketTransactionService transactionService;

	String[] authArr;

	@PostMapping("transaction/insert")
	public ResponseEntity<TransactionTicket> insertTransTiket(@RequestBody String content,
			@RequestHeader("Authorization") String authorization, @RequestParam("kode") String kodeDiskon) {
		TransactionTicket trans = new TransactionTicket();
		try {
			trans = new ObjectMapper().readValue(content, TransactionTicket.class);
			authArr = super.authUser(authorization);
			transactionService.insertTransTicket(trans, authArr[0], authArr[1], kodeDiskon);
			return new ResponseEntity<>(trans, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(trans, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("transaction/findbyid")
	public ResponseEntity<List<TicketPesanan>> findTransTiketById(@RequestParam("id") Long id,@RequestHeader("Authorization") String authorization) {
		List<TicketPesanan> ticket = new ArrayList<TicketPesanan>();
		try {
			authArr = super.authUser(authorization);
			ticket = transactionService.findById(id,authArr[0],authArr[1]);
			return new ResponseEntity<>(ticket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ticket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("ticket/findall")
	public ResponseEntity<List<TicketPesanan>> findAllTicket(@RequestHeader("Authorization") String authorization) {
		List<TicketPesanan> ticket = new ArrayList<>();
		try {
			authArr = super.authUser(authorization);
			ticket = transactionService.findAll(authArr[0],authArr[1]);
			return new ResponseEntity<>(ticket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(ticket, HttpStatus.BAD_REQUEST);
		}
	}

}
