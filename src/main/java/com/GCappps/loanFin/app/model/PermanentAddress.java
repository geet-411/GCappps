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
public class PermanentAddress {
	@Id
	private String permanentAddressId;
	private String areaName;
	private String cityName;
	private String districtName;
	private String state;
	private Long pincode;
	private Integer houseNumber;
	private String streetName;

}
