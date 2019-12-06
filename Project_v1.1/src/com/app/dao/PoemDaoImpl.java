package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Poem;
import com.app.pojos.User;

@Repository
@Transactional
public class PoemDaoImpl implements IPoemDao {
	@Autowired
	private SessionFactory sf;
	

	@Override
	public String addPoem(Poem p, Integer uid) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+p+" "+uid);
		//System.out.println("In UserDaoImpl removeShayari()");
		String jpql="select u from User u where u.id=:uid";
		sf.getCurrentSession().createQuery(jpql,User.class).
		setParameter("uid", uid).getSingleResult().addPoemInList(p);
		return "Successfully added new Poem";
	}
	@Override
	public String removePoem(Integer pid, Integer uid) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+" "+pid+" "+uid);
		//System.out.println("In UserDaoImpl addUser()");
		String jpql="select u from User u join fetch u.poemList where u.id=:uid";
		sf.getCurrentSession().createQuery(jpql,User.class).
		setParameter("uid", uid).getSingleResult().removePoemFromList(pid);
		return "Successfully removed Poem";
	}
	@Override
	public List<Poem> getPoemList(Integer uid) {
		System.out.println("In "+getClass().getName()+" "+new Exception().getStackTrace()[0].getMethodName()+" "+uid);
		String jpql="select u from User u join fetch u.poemList where u.id=:uid";
		return sf.getCurrentSession().createQuery(jpql,User.class).
		setParameter("uid", uid).getSingleResult().getPoemList();
		
	}

}
