package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cibil {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cibilId;
	
	
	private String cibilScore;
	private String cibilGeneratedDate;
	private String remark;
	private String previousEmi;

	

}
