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
import com.lawencon.tiketboot.model.Discount;
import com.lawencon.tiketboot.service.DiscountService;
@RestController
public class DiscountController extends BaseController {

	@Autowired
	private DiscountService discountService;
	Discount discount = new Discount();
	List<Discount> list = new ArrayList<Discount>();

	@PostMapping("discount/insert")
	public ResponseEntity<Discount> insertDiscount(@RequestBody String content) {
		try {
			discount = new ObjectMapper().readValue(content, Discount.class);
			discountService.insert(discount);
			return new ResponseEntity<>(discount, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(discount, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("discount/update")
	public ResponseEntity<Discount> updateDiscount(@RequestParam("id") Long id, @RequestBody String content) {
		try {
			discount = new ObjectMapper().readValue(content, Discount.class);
			discountService.update(id, discount.getKodeVoucher(), discount.getPotonganHarga());
			return new ResponseEntity<>(discount, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(discount, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("discount/delete")
	public ResponseEntity<String> insertDiscount(@RequestParam("id") Long id) {
		try {
			discountService.delete(id);
			return new ResponseEntity<>("Berhasil hapus", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal Hapus", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("discount/findall")
	public ResponseEntity<List<Discount>> findAllDiscount() {
		try {
			list = discountService.findAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("discount/getbykode")
	public ResponseEntity<Integer> getDiscountById(@RequestParam("kode") String kode) {
		try {
			Integer potongan = discountService.getDiscount(kode);
			return new ResponseEntity<>(potongan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);

		}
	}

}
