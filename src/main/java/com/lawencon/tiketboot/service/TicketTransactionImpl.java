package com.lawencon.tiketboot.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.tiketboot.dao.CustomerDao;
import com.lawencon.tiketboot.dao.DiscountDao;
import com.lawencon.tiketboot.dao.TicketDao;
import com.lawencon.tiketboot.dao.TransactionDao;
import com.lawencon.tiketboot.dao.TypeDao;
import com.lawencon.tiketboot.model.Customer;
import com.lawencon.tiketboot.model.TicketPesanan;
import com.lawencon.tiketboot.model.Transaction;
import com.lawencon.tiketboot.model.TransactionTicket;
import com.lawencon.tiketboot.model.TypeTicket;

@Service
@Transactional
public class TicketTransactionImpl implements TicketTransactionService {

	@Autowired
	@Qualifier("transaction_repo_hibernate")
	private TransactionDao transactionService;

	@Autowired
	@Qualifier("customer_repo_hibernate")
	private CustomerDao customerDao;

	@Autowired
	@Qualifier("ticket_repo_hibernate")
	private TicketDao ticketDao;

	@Autowired
	@Qualifier("type_repo_hibernate")
	private TypeDao typeDao;

	@Autowired
	@Qualifier("discount_repo_jpa")
	private DiscountDao discountDao;

	

	private Boolean checkCustomer(String username, String password) throws Exception {
		List<Customer> list = new ArrayList<>();
		list = customerDao.findByUsernamePassword(username, password);
		if (list != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public TicketPesanan insert(TicketPesanan ticket) {
		return ticketDao.insert(ticket);
	}

	@Override
	public List<TicketPesanan> findAll(String username, String password) {
		try {
			if (checkCustomer(username, password)==true) {
				return ticketDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TicketPesanan> findById(Long id,String username, String password) {
		try {
			if (checkCustomer(username, password)==true) {
				return ticketDao.findById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransactionTicket insertTransTicket(TransactionTicket trans, String username, String password,
			String kodeDiskon) {
		try {
			if (checkCustomer(username, password) == true) {
				Transaction t = trans.getTransaction();
				List<Customer> cust = customerDao.findByUsernamePassword(username, password);
				Customer customer = new Customer();
				customer.setId(cust.get(0).getId());
				customer.setNama(cust.get(0).getNama());
				customer.setUsername(cust.get(0).getUsername());
				customer.setPassword(cust.get(0).getPassword());
				t.setCustomer(customer);
				transactionService.insert(t);
				trans.getTicket().forEach(x -> {
					TicketPesanan ticket = x;
					ticket.setTransaction(t);
					TypeTicket type1 = ticket.getType();
					List<TypeTicket> list2 = new ArrayList<>();
					list2 = typeDao.findById(type1.getId());
					type1.setId(list2.get(0).getId());
					type1.setNama(list2.get(0).getNama());
					type1.setKategori(list2.get(0).getKategori());
					type1.setHarga(list2.get(0).getHarga()- discountDao.getDiscount(kodeDiskon));
					ticket.setType(type1);
					ticketDao.insert(ticket);
				

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trans;
	}

}
