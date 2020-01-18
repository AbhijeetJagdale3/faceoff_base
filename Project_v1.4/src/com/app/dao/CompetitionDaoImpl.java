package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.InvList;
import com.app.pojos.CompositeKey;
import com.app.pojos.User;

@Repository
@Transactional
public class CompetitionDaoImpl implements ICompetitionDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public String invitUser(Integer receiver , Integer sender) {
		System.out.println("In " + getClass().getName() + " " + new Exception().getStackTrace()[0].getMethodName() + " "
				+ receiver + " " + sender);
		  Session s=sf.getCurrentSession(); 
		  User usender=s.get(User.class,sender); 
		  User ureceiver=s.get(User.class,receiver); 
		  InvList i=new InvList((new CompositeKey(sender,receiver)),usender,ureceiver);
		  usender.addInSenderList(i);
		  ureceiver.addInReceiverList(i);
		return "Successfully send invitation";
	}

	@Override
	public String removeInvitation(Integer uid, Integer invitatorId) {
		System.out.println("In " + getClass().getName() + " " + new Exception().getStackTrace()[0].getMethodName());
		return "Successfully removed invitation";
	}

	@Override
	public List<User> getInvitationList(Integer uid) {
		System.out.println("In " + getClass().getName() + " " + new Exception().getStackTrace()[0].getMethodName()+" "+uid);	
		String jpql="SELECT i.sender FROM InvList i WHERE i.id.receiveId=:uid";
		return sf.getCurrentSession().createQuery(jpql,User.class).
				 setParameter("uid", uid).getResultList();
	}

	public String acceptInv(Integer uid, Integer invitatorId) {
		System.out.println("In " + getClass().getName() + " " + new Exception().getStackTrace()[0].getMethodName()+uid+" "+invitatorId);
		
		
		return "Successfully removed invitation";
	}

}









/*
 * Session hs = sf.getCurrentSession(); Vendor v = hs.get(Vendor.class,
 * vendorId); // v --persistent hs.delete(v); return "Vendor with " + vendorId +
 * " un subscribed ..."; }
 * 
 * @Override public String registerVendor(Vendor v) {
 * sf.getCurrentSession().persist(v);
 */


//Depricated
//User invUid=sf.getCurrentSession().get(User.class, invitatorId);
//System.out.println("1"+invUid);
//User invitator =sf.getCurrentSession().createQuery(jpql,User.class).
//setParameter("uid", uid).getSingleResult();
//System.out.println("2"+invitator);
//System.out.println(invitator.getInvitation());
//invitator.getInvitation();

//String jpql="select u from User u  where u.id=:uid";
//sf.getCurrentSession().createQuery(jpql,User.class).
//		setParameter("uid", invitatorId).getSingleResult().getInvitation()/* .removeInvitationFromList(uid) */;

//String jpql="SELECT u FROM User u WHERE U.id = "+"(SELECT i.senderId FROM InvList i WHERE i.receiveId=:uid)";
//String jpql="select u from User u join fetch u.receiverList where u.id = :uid";
//String jpql="select u from User u join fetch u.poemList where u.id=:uid";
//System.out.println(u.getReceiverList());

//		String jpql = "select u from User u where u.id=:uid";
//	return null;
/*
			 * sf.getCurrentSession().createQuery(jpql,User.class). setParameter("uid",
			 * uid).getSingleResult().getReceivedInvitation();
			 */

//Integer invId=sf.getCurrentSession().createQuery(jpql,User.class).
//		setParameter("uid", uid).getSingleResult().getInvitation().size();
//System.out.println("invId="+invId);
//String jpql2="select i from Invitation i join fetch i.invitationList where i.id=:invId";

/*
 * sf.getCurrentSession().createQuery(jpql2,Invitation.class).
 * setParameter("invId", invId).getSingleResult().getInvitationList();
 */

//String jpql = "select u from User u join fetch u.invitationList where u.id=:uid";
//sf.getCurrentSession().createQuery(jpql, User.class).setParameter("uid", uid).getSingleResult()
//		.removeInvitationFromList(invitatorId);
