package com.hcl.bankmanagementapp.api.dto;

public class UserDTO {

	private String first_name;
	private String last_name;
	private String email_id;
	private String mobile_no;
	private String password;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [first_name=" + first_name + ", last_name=" + last_name + ", email_id=" + email_id
				+ ", mobile_no=" + mobile_no + ", password=" + password + "]";
	}
	
	

	
}
