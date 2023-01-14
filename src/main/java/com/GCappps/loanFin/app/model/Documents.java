package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Documents {
	@Id
	private String documentId;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] incometax;
	@Lob
	private byte[] adharcard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] bankCheque;
	
	

}
