package com.GCappps.loanFin.app.serviceImpl;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.stereotype.Service;

import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.model.Installment;
import com.GCappps.loanFin.app.model.Ledger;
import com.GCappps.loanFin.app.repository.CustomerRepository;
import com.GCappps.loanFin.app.repository.LedgerRepository;
import com.GCappps.loanFin.app.serviceI.LedgerServiceI;
 
@Service
public class LedgerServiceImpl implements LedgerServiceI{
	
	@Autowired
	LedgerRepository ledRepo;
	
	@Autowired
	Ledger ledger;
	
	@Autowired
	CustomerRepository cust;

	@Override
	public Ledger ledgergeneration(Customer customer) {
		ledger.setLedgerId("CGapps-Ledger-installment"+ThreadLocalRandom.current().nextInt(999,9999));
		Calendar date = new GregorianCalendar();
		int year = date.get(Calendar.YEAR);  
		int month = date.get(Calendar.MONTH);   
		int day = date.get(Calendar.DAY_OF_MONTH);  
		ledger.setLedgerCreatedDate(day+"/"+(month+1)+"/"+year);
		ledger.setTotalLoanAmount(customer.getSanctionLetter().getLoanAmountWithInterest());
		ledger.setTenure(customer.getSanctionLetter().getLoanTenure());
		ledger.setMonthlyEMI(customer.getSanctionLetter().getMonthlyEmiAmount());
		ledger.setAmountPaidTillDate(null);
		ledger.setRemainingAmount(customer.getSanctionLetter().getLoanAmountWithInterest());
		ledger.setDefaulterCount(null);
		int lastmonth=customer.getSanctionLetter().getLoanTenure();
		
		List<Installment> l=new ArrayList<>();
		String lastdate=null;
		for(int i=1;i<=lastmonth;i++) {
			Installment install=new Installment();
			int x=(i+(month+1));
			if(x<=12) {
				 
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(x);
				install.setInstallmentMonth(monthofinstallment+","+year);
				lastdate=monthofinstallment+","+year;
			}
			else if(x>12 && x<24) {
				int m=(x)%12;
				 
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(m);
				install.setInstallmentMonth(monthofinstallment+","+(year+1));
				lastdate=monthofinstallment+","+(year+1);
				
			}
			else if(x==24) {
				 
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(12);
				install.setInstallmentMonth(monthofinstallment+","+(year+1));
				lastdate=monthofinstallment+","+(year+2);
			}
			else if((x)>24 && (x)<36) {
				int m=(x)%12;
				 
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(m);
				install.setInstallmentMonth(monthofinstallment+","+(year+2));
				lastdate=monthofinstallment+","+(year+2);
				
			}
			else if(x==36) {
				 
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(12);
				install.setInstallmentMonth(monthofinstallment+","+(year+2));
				lastdate=monthofinstallment+","+(year+2);
			}
			else if((x)>36 && (x)<48) {
				int m=(x)%12;
				install.setInstallmentNumber(x-1);
				Month monthofinstallment= Month.of(m);
				install.setInstallmentMonth(monthofinstallment+","+(year+3));
				lastdate=monthofinstallment+","+(year+3);
				
			}
			
			l.add(install);
			
			
		}
		ledger.setInstallments(l);
		ledger.setLoanEndDate(lastdate);
		ledger.setLoanStatus("Regular");
		customer.setLedger(ledger);
		cust.save(customer);
		return ledRepo.save(ledger);
	}

	@Override
	public Ledger payinstallment(Ledger ledger, Integer installmentnumber) {
		Double emi=ledger.getMonthlyEMI();
		List<Installment> list=ledger.getInstallments();
		List<Installment> installmentlist=new ArrayList<>();
		int count=0;
		for(Installment l:list) {
			if(l.getInstallmentNumber()==installmentnumber) {
				l.setPaymentStatus("Paid");
				Date date=new Date();
				l.setInstallementPaidDate(date);
			}
			installmentlist.add(l);
			ledger.setInstallments(installmentlist);
		}
		
		for(Installment l:installmentlist)	{
		try {
			if(l.getPaymentStatus().equals("Paid")) {
				count++;
			}}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
		}	
		Double paidinstallment=(emi*count);
		ledger.setAmountPaidTillDate(paidinstallment);
		Double remainamount=ledger.getTotalLoanAmount()-paidinstallment;
		ledger.setRemainingAmount(remainamount);
		return ledRepo.save(ledger);
	}

	@Override
	public Ledger unpayinstallment(Ledger ledger, Integer installmentnumber) {
		Double emi=ledger.getMonthlyEMI();
		List<Installment> list=ledger.getInstallments();
		List<Installment> installmentlist=new ArrayList<>();
		int count=0;
		for(Installment l:list) {
			if(l.getInstallmentNumber()==installmentnumber) {
				l.setPaymentStatus("UnPaid");
				Date date=new Date();
				l.setInstallementPaidDate(date);
			}
			installmentlist.add(l);
			ledger.setInstallments(installmentlist);
		}
		for(Installment l:installmentlist)	{
			try {
				if(l.getPaymentStatus().equals("UnPaid")) {
					count++;
				}}
				catch(NullPointerException e)
				{
					e.printStackTrace();
				}
				
			}	
		ledger.setDefaulterCount(count);
		return ledRepo.save(ledger);
	}

}
