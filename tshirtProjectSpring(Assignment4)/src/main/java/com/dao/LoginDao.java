package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Users;

@Repository
public class LoginDao {

		@RequestMapping("/users")
	public boolean checkLogin(String uname, String pass) {
		SessionFactory factory = new Configuration().configure("hibernateV.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Query query;
		query = session.createQuery("from Users where uname=:uname AND  pass=:pass");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);
		
		
		Users user=(Users) query.uniqueResult();
		
		if(user!=null) {
			return true;
		}

		return false;
	}
}
