package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private SalariedProfession salariedProfession;
	private SelfEmployeedProfession selfEmployedProfession;



}
