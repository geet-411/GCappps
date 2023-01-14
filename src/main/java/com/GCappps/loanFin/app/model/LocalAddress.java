package com.GCappps.loanFin.app.model;

import java.util.List;

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
public class LocalAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String localAddressId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private Long pincode;
	private Integer houseNumber;
	private String streetName;
}
