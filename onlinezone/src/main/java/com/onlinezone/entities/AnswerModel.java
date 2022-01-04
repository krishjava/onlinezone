package com.onlinezone.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "answer")
public class AnswerModel {

	@Id
	private int id;
	
	@NotBlank(message = "* must be filled")
	@Column(columnDefinition = "TEXT")
	private String answer;
	
	private Integer user_id;
	private Integer question_id;
	
	@Column(length = 11)	
	private String added_date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	
	@Override
	public String toString() {
		return "AnswerModel [id=" + id + ", answer=" + answer + ", user_id=" + user_id + ", question_id=" + question_id
				+ ", added_date=" + added_date + "]";
	}
}
