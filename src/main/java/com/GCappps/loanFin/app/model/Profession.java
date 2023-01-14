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

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Profession {
	@Id
	private String professionId;
	
	private String professionDesignation;
	@OneToOne(cascade = CascadeType.ALL)
	private SalariedProfession salariedProfession;

	@OneToOne(cascade = CascadeType.ALL)
	private SelfEmployeedProfession selfEmployedProfession;



}
