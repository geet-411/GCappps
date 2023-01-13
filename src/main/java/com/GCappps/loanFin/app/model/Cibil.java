package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
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
	private String cibilId;
	private String cibilScore;
	private String cibilGeneratedDateTime;
	private String remark;
	private String previousEmi;
	
	
	
}
