package com.onlinezone.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public boolean validateAdminUser(String username,String password) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		String query="select * from admin where email=:username and password=:pass";
		Query query2 = session.createSQLQuery(query);
		query2.setParameter("username", username);
		query2.setParameter("pass", password);
//		AdminModel admin = (AdminModel) query2.uniqueResult();
		Object admin = query2.uniqueResult();
//		for (Object[] student : list) {
//			System.out.println(Arrays.toString(student));
//		}
//		System.out.println("List : "+list);
//		return list.isEmpty()==false ? false: true;
		return admin==null ? false:true;
	}

	public boolean validateFrontUser(String email,String password) {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		String query="select * from user where email=:username and password=:pass";
		Query query2 = session.createSQLQuery(query);
		query2.setParameter("username", email);
		query2.setParameter("pass", password);
		Object admin = query2.uniqueResult();
		return admin==null ? false:true;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
