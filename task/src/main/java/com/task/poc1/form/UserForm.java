package com.task.poc1.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;
import com.task.poc1.Util.Util;
import com.task.poc1.dto.UserDTO;

public class UserForm {

	@NotNull
	protected long id;

	@NotNull
	@NotBlank
	protected String firstName;

	@NotEmpty
	@NotBlank
	protected String lastName;

	@Size(max = 10)
	@NotEmpty
	protected String phoneNo;

	@NotEmpty
	protected String state;

	@NotEmpty
	protected String city;

	@Size(min=9,max = 9)
	@NotEmpty
	protected String pincode;

	@NotEmpty
	private String dob;

	@NotEmpty
	private String gender;
	
	private Long[] chk_1;

	public Long[] getChk_1() {
		return chk_1;
	}

	public void setChk_1(Long[] chk_1) {
		this.chk_1 = chk_1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserDTO getDTO() {
		UserDTO userdto = new UserDTO();
		userdto.setId(id);
		userdto.setFirstName(firstName);
		userdto.setLastName(lastName);
		userdto.setCity(city);
		userdto.setDob(Util.getDate(dob));
		userdto.setGender(gender);
		userdto.setPhoneNo(phoneNo);
		userdto.setPincode(pincode);
		userdto.setState(state);
		return userdto;
	}

	public void populate(UserDTO user) {

		id = user.getId();
		firstName = user.getFirstName();
		lastName = user.getLastName();

		dob = Util.getDate(user.getDob());

		phoneNo = user.getPhoneNo();
		state = user.getState();
		city = user.getCity();
		pincode = user.getPincode();

		gender = user.getGender();

	}

}
