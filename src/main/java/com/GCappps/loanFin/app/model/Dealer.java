package com.GCappps.loanFin.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String dealerId;
	private String dealerName;
	private String dealerLocation;
	private String dealerLicenceId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vehicle> vehicleData;

	

}
