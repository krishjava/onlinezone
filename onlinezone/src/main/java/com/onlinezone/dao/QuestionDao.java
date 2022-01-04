package com.onlinezone.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.onlinezone.entities.QuestionModel;

@Repository
public class QuestionDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void savequestion(QuestionModel questionModel) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Integer result = (Integer) session.createSQLQuery("select max(id) from question").uniqueResult();
		questionModel.setQuestion(questionModel.getQuestion().trim().replaceAll("\n","").replaceAll("( )+", " "));
		if(result!=null) {
			questionModel.setId(result+1);
			System.out.println("User id : "+questionModel.getId());
			hibernateTemplate.save(questionModel);
		}else {
			questionModel.setId(1);
			System.out.println("User id  0 : "+questionModel.getId());
			hibernateTemplate.save(questionModel);
		}
	}
	
	public List<QuestionModel> getAllQuestion() {
		List<QuestionModel> questions = hibernateTemplate.loadAll(QuestionModel.class);
		return questions;
	}
	
	
	
	public QuestionModel getQuestion(int qid) {
		QuestionModel question = hibernateTemplate.get(QuestionModel.class,qid);
		return question;
	}
	
	public List<QuestionModel> getTopQuestionRows(){
		Session session = hibernateTemplate.getSessionFactory().openSession();
//		Query createQuery = session.createQuery("from QuestionModel order by id desc");  // this not work in the hibernate
		Query createQuery =session.createQuery("from QuestionModel order by id desc").setMaxResults(6);
		List<QuestionModel> list = createQuery.list();
		System.out.println(list);
		return list;
	}
	
	public List<QuestionModel> paginatedRows(int pageNo,int row) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query createQuery =session.createQuery("from QuestionModel order by id");
		createQuery.setFirstResult((pageNo-1)*row);
		createQuery.setMaxResults(row);
		List<QuestionModel> list = createQuery.list();
		return list;
	}
	
	public Integer maxRows() {
//		Session session = hibernateTemplate.getSessionFactory().openSession();   
//		Integer rows = (Integer) session.createSQLQuery("select count(id) from question").uniqueResult();
//		System.out.println("total rows : "+rows);
		return getAllQuestion().size();
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
