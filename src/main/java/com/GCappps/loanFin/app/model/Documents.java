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
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String documentId;
	private byte[] addressProof;
	private byte[] pancard;
	private byte[] incometax;
	private byte[] adharcard;
	private byte[] photo;
	private byte[] signature;
	private byte[] bankCheque;
	
	

}
