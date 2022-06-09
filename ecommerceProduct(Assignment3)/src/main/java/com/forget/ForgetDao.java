package com.forget;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.login.Users;

public class ForgetDao {

	// update password
	public boolean checkLogin(String uname, String pass) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Query query;
		query = session.createQuery(" update Users set pass=:pass where uname=:uname");

		query.setParameter("uname", uname);
		query.setParameter("pass", pass);

		int flag = query.executeUpdate();
		session.getTransaction().commit();

		if (flag == 1) {
			return true;
		}

		return false;
	}
}
