package com.onlinezone.front.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.onlinezone.front.model.User;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createUser(User user) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Integer result = (Integer) session.createSQLQuery("select max(id) from user").uniqueResult();
		System.out.println("Result : "+result);
		if(result!=null) {
			user.setId(result+1);
			System.out.println("User id : "+user.getId());
			hibernateTemplate.save(user);
		}else {
			user.setId(1);
			System.out.println("User id  0 : "+user.getId());
			hibernateTemplate.save(user);
		}
	}

	public String getUserEmail(String email) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query createQuery = session.createQuery("from User where email=:E");
		createQuery.setParameter("E", email);
		User check = (User) createQuery.uniqueResult();
		if (check != null) {
			return check.getEmail();
		} else {
			return "none";
		}
	}
	
	public User getUserByEmail(String email) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query createQuery = session.createQuery("from User where email=:E");
		createQuery.setParameter("E", email);
		User check = (User) createQuery.uniqueResult();
		return check;
	}
	
	public User getUserById(int id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
