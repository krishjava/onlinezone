package com.onlinezone.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.onlinezone.entities.AnswerModel;
import com.onlinezone.entities.QuestionModel;

@Repository
public class AnswerDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveAnswer(AnswerModel answerModel) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Integer result = (Integer) session.createSQLQuery("select max(id) from answer").uniqueResult();
		answerModel.setAnswer(answerModel.getAnswer().trim().replaceAll("\n","").replaceAll("( )+", " "));
		if(result!=null) {
			answerModel.setId(result+1);
			System.out.println("User id : "+answerModel.getId());
			System.out.println("Ans : "+answerModel.getAnswer());
			hibernateTemplate.save(answerModel);
		}else {
			answerModel.setId(1);
			System.out.println("User id  0 : "+answerModel.getId());
			hibernateTemplate.save(answerModel);
		}
	}
	
	public List<AnswerModel> getAllAnswer() {
		List<AnswerModel> answers = hibernateTemplate.loadAll(AnswerModel.class);
		return answers;
	}

	public AnswerModel getAnswer(int aid) {
		AnswerModel answer = hibernateTemplate.get(AnswerModel.class,aid);
		return answer;
	}
	
	public List<AnswerModel> getAnswerById(int id){
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("from AnswerModel where question_id=:Q");
		query.setParameter("Q",id);
		List<AnswerModel> list = query.list();
		System.out.println("list of answer : "+list);
		return list;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
