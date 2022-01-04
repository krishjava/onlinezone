package com.onlinezone.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "question")
public class QuestionModel {
	
	@Id
	private int id;
	
	@Size(min = 10,message = "* 10 character")
	@NotBlank(message = "* must be filled")
	private String question;
	private Integer user_id;
	private String added_date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	@Override
	public String toString() {
		return "QuestionModel [id=" + id + ", question=" + question + ", user_id=" + user_id + ", added_date="
				+ added_date + "]";
	}
}
