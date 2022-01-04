package com.onlinezone.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinezone.entities.Subject;

@Repository
public class SubjectDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public boolean createSubject(Subject subject) {
			Session session = hibernateTemplate.getSessionFactory().openSession();
			Integer result = (Integer) session.createSQLQuery("select max(id) from subject").uniqueResult();
			if(result!=null) {
				subject.setId(result+1);
				System.out.println("subjectPrimaryKey : "+subject.getId());
				Query query = session.createQuery("from Subject where subjectCode=:X or subjectName=:Y");
				query.setParameter("X",subject.getSubjectCode());
				query.setParameter("Y",subject.getSubjectName());
				List<Subject> list = query.list();
				System.out.println("subject list : "+list);
				if(list.isEmpty()) {
					System.out.println("add subject");
					hibernateTemplate.saveOrUpdate(subject);
					return true;
				}else {
					System.out.println("not add subject");
					return false;
				}
			}else {
				subject.setId(1);
				hibernateTemplate.saveOrUpdate(subject);
				return true;
			}
	}
	
	public List<Subject> getAllSubject() {
		List<Subject> loadAll = hibernateTemplate.loadAll(Subject.class);
		return loadAll;
	}
	
	public Subject getSubject(int id) {
		Subject subject = hibernateTemplate.get(Subject.class, id);
		return subject;
	}
	
	@Transactional
	public void deleteSubject(Subject subject) {
		hibernateTemplate.delete(subject);
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	} 
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
