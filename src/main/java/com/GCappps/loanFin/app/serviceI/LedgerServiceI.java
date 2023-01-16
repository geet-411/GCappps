package com.GCappps.loanFin.app.serviceI;

import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.model.Ledger;

public interface LedgerServiceI {

	public Ledger ledgergeneration(Customer customer);

	public Ledger payinstallment(Ledger ledger, Integer payinstallment);

}
