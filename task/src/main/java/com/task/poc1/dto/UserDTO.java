package com.task.poc1.dto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class UserDTO{
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	protected long id;
	
	@Column(name="FirstName",length = 50)
	protected String firstName;
	
	@Column(name="LastName",length = 50)
	protected String lastName;
	
	@Column(name="phoneNo",length = 50)
	protected String phoneNo;
	
	@Column(name="state",length = 50)
	protected String state;
	
	@Column(name="city")
	protected String city;
	
	@Column(name="pincode")
	protected String pincode;
	
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER", length = 10)
	private String gender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	

}
