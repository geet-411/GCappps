package com.GCappps.loanFin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.model.Ledger;
import com.GCappps.loanFin.app.responce.BaseResponce;
import com.GCappps.loanFin.app.serviceI.LedgerServiceI;

@RestController
@CrossOrigin("*")
@RequestMapping("/GCappps")
public class LedgerController {
	
	@Autowired
	LedgerServiceI ledservice;
	
	@PostMapping("/generateledger")
	public ResponseEntity<BaseResponce<Ledger>> ledgergeneration(@RequestBody Customer customer){
		Ledger ledger=ledservice.ledgergeneration(customer);
		BaseResponce<Ledger> base=new BaseResponce<>(200,"Leder is generated",ledger);
		return new ResponseEntity<BaseResponce<Ledger>>(base,HttpStatus.CREATED);
	}
	
	@PutMapping("/payinstallment/{installmentnumber}")
	public ResponseEntity<BaseResponce<Ledger>> payinstallment(@RequestBody Ledger ledger,@PathVariable Integer installmentnumber){
		Ledger led=ledservice.payinstallment(ledger,installmentnumber);
		BaseResponce<Ledger> base=new BaseResponce<>(200,"Installment number "+installmentnumber +" is paid",led);
		return new ResponseEntity<BaseResponce<Ledger>>(base,HttpStatus.CREATED);
	}
	
	@PutMapping("/unpayinstallment/{installmentnumber}")
	public ResponseEntity<BaseResponce<Ledger>> unpayinstallment(@RequestBody Ledger ledger,@PathVariable Integer installmentnumber){
		Ledger led=ledservice.unpayinstallment(ledger,installmentnumber);
		BaseResponce<Ledger> base=new BaseResponce<>(200,"Installment number "+installmentnumber +" is Unpaid",led);
		return new ResponseEntity<BaseResponce<Ledger>>(base,HttpStatus.CREATED);
	}

}
