package com.GCappps.loanFin.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.time.Month;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Installment {
	@Id
	private String installmentId;
	private Integer installmentnumber;
	private String installmentmonth;
	private Date installementpaiddate;
	private String paymentStatus;
	
}
