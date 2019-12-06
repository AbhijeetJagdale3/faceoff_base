package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Shayari;
import com.app.pojos.User;

@Repository
@Transactional
public class ShayariDaoImpl implements IShayariDao {
	@Autowired
	private SessionFactory sf;
	@Override
	public String addShayari(Shayari s, Integer uid) {

		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+s+" "+uid);
		String jpql="select u from User u where u.id=:uid";
		sf.getCurrentSession().createQuery(jpql,User.class).
		setParameter("uid", uid).getSingleResult().addShayariInList(s);
		return "Successfully added new Shayari";
	}
	@Override
	public String removeShayari(Integer sid, Integer uid) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+" "+sid+" "+uid);
		String jpql="select u from User u join fetch u.shayariList where u.id=:uid";
		sf.getCurrentSession().createQuery(jpql,User.class).
		setParameter("uid", uid).getSingleResult().removeShayariFromList(sid);
		return "Successfully removed Shayari";
	}
	@Override
	public List<Shayari> getShayariList(Integer uid) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+" "+uid);
		String jpql="select u from User u join fetch u.shayariList where u.id=:uid";
		return  sf.getCurrentSession().createQuery(jpql,User.class).
				setParameter("uid", uid).getSingleResult().getShayariList();
	}

}
