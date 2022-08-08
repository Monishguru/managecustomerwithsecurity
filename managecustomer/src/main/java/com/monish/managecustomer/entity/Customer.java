package com.monish.managecustomer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Customer {

	@Id
	@GeneratedValue
	private Long Id;

	private String firstName;

	private String lastName;

	private String email;

	private Long phoneNumber;

	private String address;

}
