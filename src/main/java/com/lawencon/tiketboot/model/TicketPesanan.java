package com.lawencon.tiketboot.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TicketPesanan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nama;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date tglBerangkat;
	private String kursi;
	private Integer harga;
	

	@ManyToOne
	@JoinColumn(name = "trans_id")
	private Transaction transaction;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private TypeTicket type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Date getTglBerangkat() {
		return tglBerangkat;
	}

	public void setTglBerangkat(Date tglBerangkat) {
		this.tglBerangkat = tglBerangkat;
	}

	public String getKursi() {
		return kursi;
	}

	public void setKursi(String kursi) {
		this.kursi = kursi;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TypeTicket getType() {
		return type;
	}

	public void setType(TypeTicket type) {
		this.type = type;
	}

	public Integer getHarga() {
		return harga;
	}

	public void setHarga(Integer harga) {
		this.harga = harga;
	}

}
