package com.onlinezone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.onlinezone.validator.SubjectCode;

@Entity
public class Subject {
	
	@Id
	private int id;
	
//	@Min(value = 100,message = "Must be 3 Digit")
//	@NotNull(message = "Can not be Empty")
//	@SubjectCode(minDigit = 200,maxDigit = 600,message = "SubjectCode between 200-600")
	@SubjectCode
	private Integer subjectCode;
	
//	@Min(value = 2,message = "Must have atleast 2 Character")
	@Length(min = 2,message = "Must have atleast 2 Character")
	 @NotBlank(message = "* Subject Name can not be Blank")
	 private String subjectName;
	 
//	 @Transient
//	 private long subjectId;
//	 
//	 @Transient
//	 private String status;

	 
	 public void setSubjectCode(Integer subjectCode) {
		this.subjectCode = subjectCode;
	}
	 
	 public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	 
	 public Integer getSubjectCode() {
		return subjectCode;
	}
	  
	 public String getSubjectName() {
		return subjectName;
	}
	 public void setId(int id) {
		this.id = id;
	}
	 public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + "]";
	}
}
