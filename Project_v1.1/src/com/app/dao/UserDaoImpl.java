package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public User validateUser(String email, String password) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+" "+email+" "+password);
		String jpql="select u from User u where u.email=:email and u.password=:password";

		return sf.getCurrentSession().createQuery(jpql,User.class)
				.setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}
	@Override
	public String addUser(User u) {

		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName());
		sf.getCurrentSession().persist(u);
		return "Successfully registered new User";
	}
	

}
