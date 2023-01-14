package com.GCappps.loanFin.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerAddress {
	@Id
	private String customerAddress;
	
	
	//Secondary referance
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanentAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LocalAddress localAddress;

}
