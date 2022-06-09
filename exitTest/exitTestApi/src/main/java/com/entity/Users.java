package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	String email;
	 @Column(name="firstname")
	String firstname;
	 @Column(name="lastname")
		String lastname;
	 @Column(name="password")
		String password;
	
	
	 public Users(){}
	 
	@Override
	public String toString() {
		return "Users [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + "]";
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
