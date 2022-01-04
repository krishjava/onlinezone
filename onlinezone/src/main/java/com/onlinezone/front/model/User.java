package com.onlinezone.front.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.onlinezone.validator.CheckUniqueEmail;
import com.onlinezone.validator.PasswordsEqualConstraint;
import com.sun.istack.NotNull;

@Entity
@Table(name = "user")
@PasswordsEqualConstraint(message = "* password must be matched")
public class User {

	@Id
	private int id;
	
	@NotBlank(message = "* can't be empty")
	@Email(message = "* must be an email")
	@Column(length = 40,nullable = false)
//	@CheckUniqueEmail
	private String email;
	
	@NotBlank(message = "* must be filled")
	@Column(length = 60,nullable = false)
	@Size(min = 6,max = 16,message = "* password must be 6-16 character")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", 
    message = "* invalid Password pattern. must have number, character,special symbol, lower & upper case latter"
    )
	private String password;
	
	@Transient
	@NotBlank(message = "* must be filled")
	@Size(min = 6,max = 16,message = "* password must be 6-16 character")
	private String cpassword;
	private String added_date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	
	@Override
		public String toString() {
			return "email= "+email+" password= "+password+" added_date= "+added_date;
		}
}
