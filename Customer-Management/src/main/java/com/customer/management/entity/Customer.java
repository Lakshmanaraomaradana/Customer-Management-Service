package com.customer.management.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Identity",nullable=true,unique=true)
	private int id;
	@Column(name="First_Name", nullable=false,unique=false)
	private String firstname;
	@Column(name="last_Name", nullable=false,unique=false)
	private String lastname;
	@Column(name="DOB", nullable=false,unique=false)
	@DateTimeFormat(pattern="dd/MM/YYYY")
	private Date dateOfBirth; 
	@Column(name="Join_Date")
	@Temporal(TemporalType.DATE)
	private Date joindate;
	@Column(name="Email", nullable=false,unique=false)
	private String email;

}
