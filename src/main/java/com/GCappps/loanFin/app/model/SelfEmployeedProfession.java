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
public class SelfEmployeedProfession {
	@Id
	private String selfEmployeedProfessionId;
	@Lob
	private byte[] itrDocument;
	

}
