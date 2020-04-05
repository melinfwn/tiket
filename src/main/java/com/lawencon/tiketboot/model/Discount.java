package com.lawencon.tiketboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String kodeVoucher;
	private int potonganHarga;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKodeVoucher() {
		return kodeVoucher;
	}

	public void setKodeVoucher(String kodeVoucher) {
		this.kodeVoucher = kodeVoucher;
	}

	public int getPotonganHarga() {
		return potonganHarga;
	}

	public void setPotonganHarga(int potonganHarga) {
		this.potonganHarga = potonganHarga;
	}

}
